/*
    [a,b,c] -> [bc, ac, ab]
    left[i] -> product of all elements before i (exclusive)
    right[i] -> product of all elements after i (exclusive)
        - left = [1, a, ab]
        - right = [bc, c, 1]
    multiply each element in m and n you have:
        - left*right = [1*bc, a*c, ab*1] = [bc, ac, ab]!!!!!
 */
class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int m = nums.length;
        int[] left = new int[m], right = new int[m];
        left[0] = 1;
        right[m-1] = 1;
        for (int i = 1; i < m; i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        for (int i = m - 2; i >= 0; i--) {
            right[i] = right[i+1]*nums[i+1];
        }
        for (int i = 0; i < m; i++) {
            left[i] = left[i]*right[i];
        }
        return left;
    }
}