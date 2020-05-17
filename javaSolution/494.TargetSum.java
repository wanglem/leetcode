import java.util.HashMap;
import java.util.Map;

class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargets(nums, 0, S, new HashMap<>());
    }

    private int findTargets(int[] nums, int i, int S, Map<Integer, Map<Integer, Integer>> cache) {
        if (i == nums.length) {
            if (S == 0) return 1;
            return 0;
        }

        if (cache.containsKey(i) && cache.get(i).containsKey(S)) return cache.get(i).get(S);

        int ways = findTargets(nums, i+1, S + nums[i], cache);
        ways += findTargets(nums, i+1, S - nums[i], cache);

        if (!cache.containsKey(i)) cache.put(i, new HashMap<>());
        cache.get(i).put(S, ways);
        return ways;
    }
}