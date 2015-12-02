class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        n = len(nums) - 2
        i = 0
        while i < n:
            j, k = i + 1, n + 1
            while j < k:
                if nums[i] + nums[j] + nums[k] == 0:
                    result.append(sorted([nums[i], nums[j], nums[k]]))
                    j += 1
                    while j < k and nums[j-1] == nums[j]: j += 1
                    k -= 1
                    while j < k and nums[k] == nums[k+1]: k -= 1
                elif nums[i] + nums[j] + nums[k] < 0:
                    j += 1
                else:
                    k -= 1
            i += 1
            while i < n and nums[i] == nums[i-1]: i += 1

        return result


sol = Solution()
print sol.threeSum([0,1,0,0])
