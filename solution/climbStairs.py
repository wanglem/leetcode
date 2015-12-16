# 70.
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2: return n
        p, q = 1, 2
        for i in xrange(2, n):
            p, q = q, p+q

        return q