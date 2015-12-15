# 60.
"""
    1234
    1243
    1324
    1342
    1423
    1432
    2134
"""
class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        k -= 1
        permuCountMagnitude = [1]
        for i in xrange(1,n):
            permuCountMagnitude.append(permuCountMagnitude[-1]*i)
        permuCountMagnitude.reverse()
        rs = []
        candidate = range(1,n+1)
        for i in xrange(n):
            p = (k / permuCountMagnitude[i])
            nxt = 0
            if p > 0:
                k = k%permuCountMagnitude[i]
                nxt = p%len(candidate)
            rs.append(candidate[nxt])
            del candidate[nxt]

        return "".join(map(str, rs))


s = Solution()
print s.getPermutation(1,1)