# 132.
# DP. abba c d ee d aa c
class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) < 2: return 0
        isPal = [[False for _ in s] for _ in s]
        for i in xrange(len(s)): isPal[i][i] = True
        minCut = range(0, len(s))
        for i in xrange(1, len(s)):
            minCut[i] = minCut[i-1]+1
            for j in xrange(i):
                if s[j] == s[i] and (isPal[j+1][i-1] or i-j == 1): # deal with even or odd palindrome
                    isPal[j][i] = True
                    if j == 0:
                        minCut[i] = 0
                    else:
                        minCut[i] = min(minCut[j-1]+1, minCut[i])

        return minCut[-1]

s = Solution()
print s.minCut("aab")