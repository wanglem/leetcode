# 191. hamming count, count all 1s in a number of binary format
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n != 0:
            if n & 1 == 1: count += 1
            n >>= 1
        return count


s = Solution()
print s.hammingWeight(15)