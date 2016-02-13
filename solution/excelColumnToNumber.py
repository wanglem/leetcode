# 171. excel column title to number
# A -> 1, AB -> 28, AA -> 27
# base 26 translation
# ACB -> 1*pow(26, 2) + 3*pow(26,1) + 2*pow(26, 0)
class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        addup, base, n = 0, ord('A'), len(s)

        for i in xrange(n):
            charInt = ord(s[n-i-1]) - base + 1
            addup += charInt*pow(26, i)

        return addup

s = Solution()
print s.titleToNumber("BA")