import java.util.HashSet;
import java.util.Set;

// sliding window of k
// find any so sliding window as long as we find one, we are good
class ContainDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> windowK = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (windowK.contains(nums[i])) return true;
            windowK.add(nums[i]);
            if (windowK.size() > k) windowK.remove(nums[i - k]);
        }
        return false;
    }

}