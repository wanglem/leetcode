# 77.
# recursive, pass k - 1
# when c == 1 return 1 to biggest possible start: n-k+2
# add from biggest of each combination to n at each level
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        return self._combine(n, k, k)

    # c is k, but a counter
    def _combine(self, n, k, c):
        if c == 1: return [[i] for i in xrange(1, n-k+2)]
        results = self._combine(n, k, c-1)
        resultsAdded = []
        for r in results:
            ma = r[-1] # max value of this combination
            for i in xrange(ma+1,n+1):
                rAdded = r + [i]
                resultsAdded.append(rAdded)

        return resultsAdded

s = Solution()
print s.combine(4, 3)