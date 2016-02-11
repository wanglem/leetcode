# 161. determine if two string is one edit distance
class Solution(object):
    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) > len(t): s, t = t, s
        sl , tl = len(s), len(t)
        if tl - sl > 1 or tl == 0: return False
        if sl == 0: return True
        i = 0
        while i<sl:
            if s[i] == t[i]: 
                i += 1
                continue
            j = i
            # try shift shorter one if any
            if sl < tl:
                while j < sl and s[j] == t[j+1]:
                    j += 1
                if j == sl: return True
                return False

            j = i+1
            # try replace current if len same
            while j < sl:
                if s[j] != t[j]: return False
                j += 1
            return True
        return i == tl-1

s = Solution()
a = "a"
b = "ba"
print s.isOneEditDistance(a, b)

