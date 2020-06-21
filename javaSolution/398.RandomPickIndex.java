import java.util.*;

// FB
class RandomPickIndex {
    private Map<Integer, List<Integer>> valueIndices;
    private Random r;
    public RandomPickIndex(int[] N) {
        valueIndices = new HashMap<>();
        r = new Random();
        for (int i = 0; i < N.length; i++) {
            valueIndices.putIfAbsent(N[i], new ArrayList<>());
            valueIndices.get(N[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = valueIndices.get(target);
        return indices.get(r.nextInt(indices.size()));
    }
}