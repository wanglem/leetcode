# 84.
# For each bar in height, assume it's the minimum of a rectangle, reach left and right, and calculate maxArea.
# To do so:
# 1. create empty stack S
# 2. for each index of height
#   1> if S.isEmpty or height[index] > S[-1]: push i to S (non-decreasing order)
#   2> else: keep popping S to get i, use this as minimum bar for rectangle, now the right index it can reach is index
#            and left index it S[-1] (All poped bar indexes are greater than it)
# 3. if still left in S, popping it like step 2
class Solution(object):
    def largestRectangleArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height: return 0
        maxArea = height[0]
        for i in xrange(1, len(height)):
            p = i
            while p >= 0:
                currentMax = min(height[p:i+1]) * (i-p+1)
                maxArea = max(maxArea, currentMax)
                p -= 1

        return maxArea

    def largestAreaImproved(self, height):
        return max(self.reach(height), self.reach(height[::-1]))

    def reach(self, height):
        if not height: return 0
        dp = [0]
        i = 1
        maxArea = height[0]
        while i < len(height):
            if height[i] >= height[dp[-1]]:
                dp.append(i)
            else:
                j = len(dp) - 1
                while j >= 0:
                    if height[i] >= height[dp[-1]]:
                        dp.append(i)
                        break
                    maxArea = max(maxArea, height[dp[-1]]*(i-dp[j]+1))
                    dp.pop()
                    j -= 1
            i += 1
        return maxArea
                

s = Solution()
print s.reach([0,2,0])