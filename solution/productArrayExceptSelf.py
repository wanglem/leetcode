# 238. product of an array expcet for self, no division
# pre-build 0~i, and i~n-1 product, cross multiply
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums) <= 2: return nums[::-1]
        rst = [1]
        for i in xrange(1, len(nums)):
            rst.append(rst[-1]*nums[i-1])
        for i in xrange(len(nums)-2, 0, -1):
            nums[i] = nums[i+1]*nums[i]

        rst[0] = nums[1]
        for i in xrange(1, len(nums)-1):
            rst[i] = rst[i]*nums[i+1]

        return rst


s = Solution()
print s.productExceptSelf([1,0])