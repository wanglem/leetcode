import java.util.TreeSet;

class ContainDuplicatesIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> windowK = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer up = windowK.ceiling(nums[i]);
            if (up != null && nums[i] >= up - t) return true;
            Integer down = windowK.floor(nums[i]);
            if (down != null && nums[i] <= t + down) return true;
            windowK.add(nums[i]);
            if (windowK.size() > k) windowK.remove(nums[i - k]);
        }

        return false;
    }

}