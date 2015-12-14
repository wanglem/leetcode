# 58.
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = 0
        started = False
        for i in xrange(len(s)-1, -1, -1):
            if s[i] != ' ':
                started = True
                length += 1
            elif started:
                return length
        return length


s = Solution()
print s.lengthOfLastWord(" ab  c  ")