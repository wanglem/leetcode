// FB
// attention to index out of range exception
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = m-1, ni = n-1;
        for (int i = m+n-1; i >= 0; i--) {
            if (ni < 0 || (mi >=0 && nums1[mi] > nums2[ni])) { // index our of range ex
                nums1[i] = nums1[mi--];
            } else {
                nums1[i] = nums2[ni--];
            }
        }
    }
}