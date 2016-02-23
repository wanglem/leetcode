# 259. 3 sum smaller
# Given an array of n integers nums and a target, find the number of 
# nums[i] + nums[j] + nums[k] < target.
# 
# I used two pointer and then bsearch the third
# actually, just loop i. pointer j and k can be converge to center, and add
# k-j to count when one triplet found.

class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        total = 0
        nums = sorted(nums)
        for i in xrange(len(nums)-2):
            for j in xrange(i+1, len(nums) - 1):
                thirdIndex = self.searchSmaller(nums, j+1, len(nums), target-nums[i]-nums[j]-1)
                if thirdIndex == -1: break
                total += thirdIndex-j-1

        return total


    def searchSmaller(self, nums, start, end, target):
        # return largest index that nums[index] > target
        if nums[start] > target: return -1
        while start < end:
            mid = (end-start)/2+start
            if target < nums[mid]: end = mid
            else: start = mid+1
        return start


nums = [1,1,-2]
s = Solution()
print s.threeSumSmaller(nums, 1)