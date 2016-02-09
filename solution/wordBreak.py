# 139.
# handle j == 0  and j != 0  check word differently
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """

        canBreak = [False for _ in s]

        for i in xrange(len(canBreak)):
            for j in xrange(i+1):
                if (j == 0 and s[j:i+1] in wordDict) or (canBreak[j] and s[j+1:i+1] in wordDict):
                    canBreak[i] = True

        return canBreak[-1]

s = Solution()
t = "leetcode"
wordDict = set(['leet', 'code'])

print s.wordBreak(t, wordDict)