# 276. paint N posts, no more two adjacent posts have same color
# recursive solution is too slow, dp works better
# basically the idea is, current house can be painted two ways:
# 1. first assume previously two is same, then dp[-1] is 1, so dp[-2]*(k-1)
# 2. previously two is different, but dp[-1] contains pre two houses same, 
#    so to take out pre two same part, we do dp[-1]/k * (k-1), thus current 
#    house has k ways, so dp[-1]/k*(k-1)*k = dp[-1]*(k-1)
# then keep repeat step 1 and 2 till reach total n houses
class Solution(object):
    def numWays(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        if n <=0 or k <=0: return 0
        return k*self.paint(n-1, k, False)

    def paint(self, n, k, previousEqual):
        if n == 0: return 1
        total = 0
        if not previousEqual:
            total += self.paint(n-1, k, True)
        total += (k-1) * self.paint(n-1, k, False)
            
        return total

    def numWays2(self, n, k):
        if n <=0 or k <= 0: return 0
        if n == 1: return k
        if k == 1 and n > 2: return 0
        ways = [k, k*k]
        for _ in xrange(2,n):
            ways.append((k-1)*ways[-1]+(k-1)*ways[-2])

        return ways[-1]

s = Solution()
print s.numWays2(32, 2)