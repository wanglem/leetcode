import java.util.*;

class Resurrection {

    public int firstMissingPositive(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        for (int n: nums) {
            if (n > 0 && n <= nums.length) {
                mark[n-1] = true;
            }
        }
        for (int i = 0; i < mark.length; i++) {
            if (!mark[i]) return i+1;
        }
        return mark.length+1;
    }
}
