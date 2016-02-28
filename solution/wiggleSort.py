# 280. wiggle sort, even index >= adjacent, odd index <= adjacent
# idea is swap. keep comparing with next
# if i odd and num[i] < num[i+1], we know that num[i-1] < num[i]
# we have num[i-1] < num[i+1], now we can swap(i, i+1)
# similar for i is even number
class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        for i in xrange(len(nums)-1):
            if i % 2 == 0 ^ (nums[i] < nums[i+1]):
                nums[i], nums[i+1] = nums[i+1], nums[i]

s = Solution()
t = [2,1]
s.wiggleSort(t)
print t