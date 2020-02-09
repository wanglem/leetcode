import java.util.*;

class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length - 1) {
            List<Integer> arr = new ArrayList<>();
            arr.add(nums[start]);
            res.add(arr);
            return res;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (seen.contains(nums[i])) continue;
            seen.add(nums[i]);
            swap(nums, start, i);
            List<List<Integer>> tails = permute(nums, start+1);
            tails.forEach(l -> {
                l.add(0, nums[start]);
                res.add(l);
            });
            swap(nums, i, start);
        }
        return res;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}