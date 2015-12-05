# 38
class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        say = "1"
        if n == 1: return say
        for i in xrange(0,n-1):
            say = self._sayNumber(say)

        return say

    def _sayNumber(self, num):
        bufCount = 1
        result = ""
        for i in xrange(1, len(num)):
            if num[i] == num[i-1]:
                bufCount += 1
            else:
                result += str(bufCount) + num[i-1]
                bufCount = 1
        return (result + str(bufCount) + str(num[-1]))

s = Solution()
print s.countAndSay(2)