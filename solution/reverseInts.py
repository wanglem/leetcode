class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        sign = 1 if x > 0 else -1
        x *= sign
        result = 0
        while x > 0:
        	result = result*10 + x%10
        	if 2147483647 < result: return 0
        	x /= 10

        return result*sign

sol = Solution()

print sol.reverse(123123123123123)