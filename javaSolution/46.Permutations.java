import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// all perm of nums
class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        return permuteAll(nums, 0);
    }
    private List<List<Integer>> permuteAll(int[] nums, int index) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length - 1 == index) {
            res.add(Arrays.asList(nums[index]));
            return res;
        }
        List<List<Integer>> childPerms = permuteAll(nums, index+1);
        for (List<Integer> childPerm : childPerms) {
            for (int i = 0; i < childPerm.size() + 1; i++) {
                ArrayList<Integer> toAdd = new ArrayList<>(childPerm);
                toAdd.add(i, nums[index]);
                res.add(toAdd);
            }
        }
        return res;
    }
}