# 169. classic question, boyer-moore majority vote problem
# The idea is, if majority > n/2 times, then it's count > all other
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        majority, count = 0, 0

        for n in nums:
            if count == 0: majority = n
            if n == majority: count += 1
            else: count -= 1

        return majority


s = Solution()
print s.majorityElement([1,2,3,3,3])
