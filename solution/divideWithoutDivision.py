class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        sign = 1
        if dividend < 0: 
            dividend = -dividend
            sign = -sign
        if divisor < 0: 
            divisor = -divisor
            sign = -sign
        if dividend == 0 or dividend < divisor: return 0
        if dividend > 2147483647: return 2147483647 if sign > 0 else -dividend
        result = 1
        magnitude = divisor
        while (magnitude << 1) < dividend:
            result += result
            magnitude = magnitude << 1

        while divisor < dividend - magnitude:
            divisor += divisor
            result += 1

        return result if sign > 0 else -result

sol = Solution()
print sol.divide(10, 3)