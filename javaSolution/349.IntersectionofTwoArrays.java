import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> lookup = new HashSet<>();
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        for (int n: nums1) {
            lookup.add(n);
        }

        Set<Integer> res = new HashSet<>();
        for (int n: nums2) {
            if (lookup.contains(n)) {
                res.add(n);
            }
        }
        int[] returnVal = new int[res.size()];
        int i = 0;
        for (int n: res) {
            returnVal[i++] = n;
        }

        return returnVal;
    }
}