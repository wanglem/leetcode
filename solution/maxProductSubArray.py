# 152. max product sub array
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        subMax = subMin = 1
        result = nums[0]
        for n in nums:
            if n == 0:
                subMin = subMax = 1
                result = max(result, 0)
                continue
            subMin, subMax = min(subMin*n, subMax*n), max(subMin*n, subMax*n)
            if subMax < 0: subMax = 1
            else: result = max(subMax, result)
        return result


s = Solution()
t = [3, -1, 4]
print s.maxProduct(t)