# 216. find combination of unique k number [1-9] that add up to n
# first number must be in range [1, n/k], other wise definitely overflow
class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        return self._helper(k, 0, n, n/k)
    
    def _helper(self, k, lo, n, step):
        # return (set(biggest number in a result set), [all results])
        if lo > n: return []
        if k == 1: 
            if n <= 9: return [[n]]
            return []
        cap = n/k
        rs = []
        for i in xrange(lo, step+lo): # must less than cap
            if i == 0: continue
            result = self._helper(k-1, i+1, n-i, step)
            if result:
                rs.extend([[i]+r for r in result])
        return rs

s = Solution()
print s.combinationSum3(2, 18)