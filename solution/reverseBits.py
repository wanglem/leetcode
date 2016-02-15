# 190. 
# get Kth bit, setup a mask and shift 1 to Kth, then & operation
class Solution(object):
    def reverseBits(self, n):
        """
        :type n: int
        :rtype: int
        """
        m = 0
        for i in xrange(32):
            m <<= 1
            mask = 1 << i
            m |= (mask & n) >> i
        return m


s = Solution()
print s.reverseBits(43261596)