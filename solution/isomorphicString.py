# 205. isomorphic string, replace same chars of sto another chars to be transformed 
# to t. no two chars can be replaced to same char (no many to one)
# 
class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t): return False
        translate = {}
        seen = set()
        used = set()
        for i in xrange(len(s)):
            if s[i] == t[i]:
                seen.add(s[i])
                used.add(t[i])
                if s[i] in translate: return False
                continue
            if s[i] not in translate:
                if t[i] in used or s[i] in seen: return False
                translate[s[i]] = t[i]
                used.add(t[i])
                seen.add(s[i])
            elif translate[s[i]] != t[i]:
                return False
        return True

s = Solution()
print s.isIsomorphic("ab", "aa")