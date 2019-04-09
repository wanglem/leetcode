import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
// find all combinations from candidates sum to target
// candidate can  repeated used
class CombinationSum {
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findComSum(candidates, target, 0);
    }

    private List<List<Integer>> findComSum(int[] candidates, int target, int index) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates[index] > target) {
            return res;
        }
        if (candidates[index] == target) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(candidates[index]);
            res.add(arr);
            return res;
        }

        for (int i = index; i < candidates.length; i++) {
            List<List<Integer>> childSolutions = findComSum(candidates, target - candidates[i], i);
            for (List<Integer> childSolution: childSolutions) {
                List<Integer> cur = new ArrayList<>(childSolution);
                cur.add(candidates[i]);
                res.add(cur);
            }
        }
        return res;
    }
}