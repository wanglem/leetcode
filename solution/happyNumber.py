# 202. happy number, recursive sum square of each digit leads to 1
# 19 is happy number.
# sqrt(1) + sqrt(9) = 82
# sqrt(8) + sqrt(2) = 68
# sqrt(6) + sqrt(8) = 100
# sqrt(1) + sqrt(0) + sqrt(0) = 1
# prevent endless repeating loop
class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        sumdigit = 0
        seen = set()
        while n not in seen:
            seen.add(n)
            while n != 0:
                d = n % 10
                sumdigit += d*d
                n /= 10
            if sumdigit == 1: return True
            n, sumdigit = sumdigit, 0

        return False
s = Solution()
print s.isHappy(2)