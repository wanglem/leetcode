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

    // if only int array it self can be loaded, use reservoir samping

    private int[] nums;
    private Random rnd;

    public void InitReservoir(int[] nums) {
        nums = nums;
        rnd = new Random();
    }

    public int pickReservoir(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }
}