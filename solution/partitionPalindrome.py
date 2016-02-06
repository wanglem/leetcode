# 131.
# no good solution, just iterate through and find all possibilities
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        return self.dfs(s)
    
    def dfs(self, s):
        if len(s) == 0: return [[]]

        result = []
        for i in xrange(1, len(s)+1):
            if self.isPalindrome(s[:i]):
                path = [[s[:i]] + e for e in self.dfs(s[i:])]
                result.extend(path)


        return result
    
    def isPalindrome(self, s):
        i = 0
        while i < len(s) and s[i] == s[len(s)-i-1]:
            i += 1

        return i == len(s)

s = Solution()
a = "aab"
print s.partition(a)