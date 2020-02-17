import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Resurrection {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preof = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int toTake = prerequisites[i][0];
            int toTakePre = prerequisites[i][1];
            if (!preof.containsKey(toTake)) {
                preof.put(toTake, new HashSet<>());
            }
            preof.get(toTake).add(toTakePre);
        }

        boolean[] learnt = new boolean[numCourses];
        Set<Integer> nonLeaf = preof
                .values()
                .stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());
        Set<Integer> leaves = new HashSet<>(preof.keySet());
        leaves.removeAll(nonLeaf);
        if (leaves.isEmpty()) return new int[]{};
        List<Integer> sorted = new ArrayList<>();
        for (Integer noPre: leaves) {
            List<Integer> toLearn = learn(noPre, learnt, new HashSet<>(), preof);
            if (toLearn.isEmpty()) return new int[]{};
            sorted.addAll(toLearn);
        }

        int[] courseOrder = new int[numCourses];
        int i = 0;
        while (i < sorted.size()) {
            courseOrder[i] = sorted.get(i);
            i++;
        }
        for (int j = 0; j < numCourses; j++) {
            if (!learnt[j]) courseOrder[i++] = j;
        }
        return courseOrder;
    }

    private List<Integer> learn(int start, boolean[] learnt, Set<Integer> seen, Map<Integer, Set<Integer>> preof) {
        if (seen.contains(start)) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        seen.add(start);
        for (Integer pre: preof.getOrDefault(start, new HashSet<>())) {
            if (learnt[pre]) continue;
            List<Integer> toLearn = learn(pre, learnt, seen, preof);
            if (toLearn.isEmpty()) return new ArrayList<>();
            res.addAll(toLearn);
        }

        res.add(start);
        seen.remove(start);
        learnt[start] = true;
        return res;
    }
}
