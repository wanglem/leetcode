class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        result = ""
        if len(strs) == 0: return result
        if len(strs) == 1: return strs[0]
        for x in strs:
            if len(x) == 0: return result

        first = strs[0]
        for i in xrange(0, len(first)):
            for s in strs:
                if i >= len(s): return result
                if first[i] != s[i]: return result
            result += first[i]
        return result

sol = Solution()
s = ["a", "b"]
print sol.longestCommonPrefix(s)