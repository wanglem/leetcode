class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        i, j = 0, len(height) - 1
        maxArea = min(height[i], height[j])*(j-i)
        minHeight = min(height[i], height[j])
        while i < j:
            if height[i] > minHeight or height[j] > minHeight:
                maxArea = max(maxArea, min(height[i], height[j])*(j-i))
            if height[i] <= height[j]:  i += 1
            else:                       j -= 1

        return maxArea

sol = Solution()
print sol.maxArea([1,2])