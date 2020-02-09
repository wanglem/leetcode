import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
// find all combinations from candidates sum to target
// candidate can  repeated used
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return getCombo(candidates, 0, target);
    }

    private List<List<Integer>> getCombo(int[] candidates, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates[start] > target) {
            return res;
        }
        for (; start < candidates.length; start++) {
            if (candidates[start] == target) {
                List<Integer> arr = new ArrayList<>();
                arr.add(target);
                res.add(arr);
            }
            List<List<Integer>> tails = getCombo(candidates, start, target - candidates[start]);
            for (List<Integer> tail: tails) {
                tail.add(candidates[start]);
                res.add(tail);
            }
        }
        return res;
    }
}