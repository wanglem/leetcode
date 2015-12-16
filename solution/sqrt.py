# 69.
class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 2: return x

        l, r = 1, x - 1
        mid = 1
        while l < r-1:
        	mid = (l+r)/2
        	if mid > x/mid: r = mid
        	elif mid < x/mid: l = mid
        	else: return mid

        return (l+r)/2


s = Solution()

print s.mySqrt(8)