class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stringlen = len(s)
        for i in xrange(0, stringlen):
            if self.isValidParentheses(s[i:]) or self.isValidParentheses(s[:len(s)-i]):
                return stringlen - i
        return 0

    def isValidParentheses(self, s):
        if not s: return True
        if s[0] != "(": return False
        buf = []
        for x in s:
            if x == "(": buf.append(x)
            elif x == ")":
                if not buf: return False
                buf.pop()
            else: 
                return False
        return not buf




sol = Solution()
a = "("
print sol.longestValidParentheses(a)
        