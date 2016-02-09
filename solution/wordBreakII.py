# 140.
# s = "catsanddog",
# dict = ["cat", "cats", "and", "sand", "dog"].
# A solution is ["cats and dog", "cat sand dog"].

# solution:
# DFS is the general idea, usually if find all possibilities no good solution
# one improvement is dp[n], dp[i] means no valid combination from i->n. saved some recomputation
# for example: if (1-i) is valid, (i-n) is not valid -> dp[i] = False
#              Then: if (1-k, k-i) is valid, no need to compute (i-n) again.
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        def wb(s, start, wordDict, dp):  
            if start == len(s): return [[]]
            if not dp[start]: return []
            result = []
            for i in xrange(start+1, len(s)+1):
                word = s[start:i]
                if word in wordDict: 
                    rest = wb(s, i, wordDict, dp)
                    if rest:
                        result.extend([[word]+r for r in rest])
            if not result: dp[start] = False
            return result

        # dp[i] is False means there's no valid sequence from i -> len(s)
        dp = [True for _ in s]
        wordList = wb(s, 0, wordDict, dp)
        return [" ".join(m) for m in wordList]


    def wordBreakDP(self, s, wordDict):
        dp = [[False for _ in s] for _ in s]

        for i in xrange(len(s)):
            for j in xrange(i, len(s)):
                if s[i:j+1] in wordDict: dp[i][j] = True

        return self._findAllPath(s, dp, 0)

    def _findAllPath(self, s, dp, rowIndex):
        result = []
        n = len(s)
        if rowIndex >= n: return []
        for i in xrange(n):
            if not dp[rowIndex][i]: continue

            rest = self._findAllPath(s, dp, i+1)
            if rest:
                result.extend([[s[rowIndex:i+1]] + r for r in rest])
        if dp[rowIndex][n-1]:
            result.append([s[rowIndex:i+1]])

        return result



st = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
d = set(["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"])

st = "cator"
d = ['cat', 'or']
# st = "catsanddog"
# d = ["cat", "cats", "and", "sand", "dog"]
s = Solution()
print s.wordBreak(st, d)