import java.util.ArrayList;
import java.util.List;

class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(build(lower, upper));
            return res;
        }
        if (nums[0] > lower) {
            res.add(build(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1] - 1) {
                res.add(build(nums[i]+1, nums[i+1]-1));
            }
        }
        if (nums[nums.length-1] != upper) {
            res.add(build(nums[nums.length-1]+1, upper));
        }
        return res;
    }

    private String build(int l, int h) {
        if (l == h) return String.format("%d", l);
        return String.format("%d->%d", l, h);
    }
}