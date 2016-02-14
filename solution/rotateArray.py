# 189. rotate array
# O(1) space and O(n) time: jump K steps forward
# loop len(nums) times, keep a move next k each time, return to head when off index.
# need avoid coming back to swapped nodes:
# keep track of start nodes on each jump cycle, shift right 1 if met
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        m = len(nums)
        k = k % m
        if m < 2 or k == 0: return
        offset = 0
        tmp = nums[0]
        next = 0
        for i in xrange(m):
            next = (next + k) % m
            tmp, nums[next] = nums[next], tmp
            if next == offset:
                offset = next+1
                next = offset
                tmp = nums[offset]

        return nums

s =  Solution()
print s.rotate(range(1,3),1)