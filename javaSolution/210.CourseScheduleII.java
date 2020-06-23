import java.util.*;
import java.util.stream.Collectors;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> learn = new HashMap<>();
        for (int[] pre: prerequisites) {
            int src = pre[1];
            int dest = pre[0];
            learn.putIfAbsent(src, new HashSet<>());
            learn.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> canLearn = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (inDegree[course] == 0) {
                canLearn.offer(course);
            }
        }
        int i = 0;
        int[] learnOrder = new int[numCourses];
        while (!canLearn.isEmpty()) {
            int toLearn = canLearn.poll();
            learnOrder[i++] = toLearn;
            for (int dep: learn.getOrDefault(toLearn, new HashSet<>())) {
                inDegree[dep]--;
                if (inDegree[dep] == 0) {
                    learn.get(toLearn).remove(dep);
                    canLearn.offer(dep);
                }
            }
        }
        if (i == numCourses) return learnOrder;
        return new int[0];
    }
}