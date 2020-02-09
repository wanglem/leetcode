import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Resurrection {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int large = nums[0], largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            large = Math.max(large + nums[i], nums[i]);
            largest = Math.max(large, largest);

        }
        return largest;
    }
}