# 264. ugly number II, 3 array record next biggest of each divisor
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1: return 1
        pts = [1,0,0]
        icrt = [[2,3,5]]
        current = 2
        i = 2
        while i < n:
            icrt.append([2*current, 3*current, 5*current])
            print current, pts, icrt
            candidate = [icrt[pts[0]][0], icrt[pts[1]][1], icrt[pts[2]][2]]
            current = min(candidate)
            pts[self.getSmallest(candidate)] += 1
            i += 1
        return current
    def getSmallest(self, candidate):
        minC = min(candidate)
        if minC == candidate[0]: return 0
        if minC == candidate[1]: return 1
        return 2

s = Solution()
print s.nthUglyNumber(6)
print s.nthUglyNumber(7)
