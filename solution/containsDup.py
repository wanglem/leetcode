# 217. check if array contains dup
class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        record = set()
        for n in nums:
            if n in record: return True
            record.add(n)
        return False