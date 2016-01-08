# 76.
# S = "ADOBECODEBANC"
# T = "ABC"
# two pointer, keep track of count of each element in t
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not t: return ""
        if not s: return ""
        rs = s
        recorded = []
        tmap = {}
        tbit = {}
        for x in t: 
            tmap[x] = 0
            tbit[x] = 0
        p = 0
        for i in xrange(len(s)):
            if s[i] in tmap: 
                tmap[s[i]] = tmap[s[i]] + 1
                tbit[s[i]] = 1
            currentSum = sum(tbit.values())
            while currentSum == len(t):
                if i - p + 1 < len(rs): rs = s[p:i+1]
                if (s[p] in tmap):
                    tmap[s[p]] = tmap[s[p]] - 1
                    if tmap[s[p]] == 0: 
                        tbit[s[p]] = 0
                        currentSum -= 1
                p += 1

        return rs

s = Solution()

print s.minWindow("ADOBECODEBANC", "")



