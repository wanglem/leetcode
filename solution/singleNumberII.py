# 137.
# Solution,
# Cannot use XOR, make a 32 bit array counter, each i represents a bit,
# at end modular each i by 3. number appeared 3 times should reduced to 0
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        