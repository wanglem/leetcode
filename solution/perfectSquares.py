# 279. perfect squares. find minimum square numbers that can add up to n
# e.g. 88 = 9^2 + 2^2 + 1^2 + 1^2 + 1^2 return 5
# optimization: keep a cache as minCountCache that stores minimum 
# square numbers needed for k. Avoid duplicate computation.
import math
class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 1: return 0
        ceiling = int(math.sqrt(n))
        return self.numSquaresWithCeiling(n, ceiling, {})

    def numSquaresWithCeiling(self, n, ceiling, minCountCache):
        if n in minCountCache: return minCountCache[n]
        while pow(ceiling, 2) > n:
            ceiling -= 1
        minCount = n
        for i in xrange(ceiling, 0, -1):
            ceilSquare = pow(i, 2)
            curCount = n/ceilSquare
            remain = n % ceilSquare
            if remain != 0:
                curCount += self.numSquaresWithCeiling(remain, i, minCountCache)
            minCount = min(minCount, curCount)
        if n not in minCountCache:
            minCountCache[n] = minCount
        else:
            minCountCache[n] = min(minCountCache[n], minCount)
        return minCount

s = Solution()
print s.numSquares(9372)