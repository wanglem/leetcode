# 254. find all combinations of factors that to n
# Tricky! Idea is next recursion start point should be bigger previously select low
# for example, Input 12,
#              First: from 2 -> 11, say we select 6,
#              Second: recursion start low from 6. To avoid 2,6 and 6,2 issue
class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        return self._get(n, 2, False)


    def _get(self, n, start, divided):
        result = []
        lo, hi = start, n-1

        while lo < hi:
            if n % lo == 0:
                hi = n/lo
                remains = self._get(n/lo, lo, True)
                result.extend([[lo]+r for r in remains])
            lo += 1
        if divided and start <= n: result.append([n])
        return result

s = Solution()
print s.getFactors(24)