import java.util.*;

class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return new ArrayList<>(getCombo(candidates, 0, target));
    }

    private Set<List<Integer>> getCombo(int[] candidates, int start, int target) {
        Set<List<Integer>> res = new HashSet<>();
        if (start == candidates.length || candidates[start] > target) {
            return res;
        }
        for (; start < candidates.length; start++) {
            if (candidates[start] == target) {
                List<Integer> arr = new ArrayList<>();
                arr.add(target);
                res.add(arr);
            }
            Set<List<Integer>> tails = getCombo(candidates, start+1, target - candidates[start]);
            for (List<Integer> tail: tails) {
                tail.add(candidates[start]);
                res.add(tail);
            }
        }
        return res;
    }
}