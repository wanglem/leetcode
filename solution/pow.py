# 50
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        flag = 1 if n > 0 else -1
        n *= flag
        rs = self._powBitWay(x, n)
        return rs if flag == 1 else 1/rs

    def _powBitWay(self, x, n):
        if n == 0: return 1
        if n == 1: return x
        rs = self._powBitWay(x, n/2)
        rs *= rs
        return rs if n%2 == 0 else rs*x

s = Solution()
print s.myPow(2, 10)