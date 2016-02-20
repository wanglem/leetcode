# 228. sorted int list, return ranges
# two pointer, take care of last range edge case by appending a value
class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums: return []
        i, j = 0, 1
        nums.append(nums[-1])
        result = []
        while j < len(nums):
            if nums[j] != nums[j-1] + 1:
                rg = str(nums[i])
                if i != j-1:
                    rg += "->" + str(nums[j-1])
                result.append(rg)
                i = j
            j += 1
        nums.pop()
        return result

s = Solution()
print s.summaryRanges([])