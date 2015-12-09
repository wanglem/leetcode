# 44
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """

        if len(p) == 0 and len(s) == 0: return True
        if len(p) == 0 or len(s) == 0: return False
        def regulate(p):
            rs = p[0]
            for x in xrange(1, len(p)):
                if not (p[x] == "*" and p[x-1] == "*"):
                    rs += p[x]
            return rs
        return self._isMatch(s, 0, regulate(p), 0)

    def _isMatch(self, s, si, p, pi):

        if si == len(s) and pi == len(p): return True
        if si == len(s): return False
        if pi == len(p):
            if p[pi-1] == '*': return True
            else: return False
        
        if p[pi] == '?':
            return self._isMatch(s, si+1, p, pi+1)
        elif p[pi] == '*':
            for siSub in xrange(len(s)-1,si+1, -1):
                startMatched = self._isMatch(s, siSub, p, pi+1)
                if startMatched: return True
            return False
        elif s[si] == p[pi]:
            return self._isMatch(s, si+1, p, pi+1)
        else:
            return False

s = Solution()
q = "aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab"
p = "*ab***ba**b*b*aaab*b"
print s.isMatch(q, p)