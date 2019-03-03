import java.util.*;

class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right) {
                int curSum = nums[left] + nums[right];
                if (curSum == target) {
                    List<Integer> found = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    res.add(found);
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                } else if (curSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}