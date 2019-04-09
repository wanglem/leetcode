// find i, j in array as two bars hold most water
// two pointers, O(n)
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
