# 159. longest substring with at most two distinct char
class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) < 2: return len(s)
        i = 0
        while i < len(s) - 1 and s[i] == s[i+1]:
            i += 1
        if i == len(s) - 1: return i+1
        result = i+2
        subLongest = i+2
        c1, c2 = s[i], s[i+1]
        c2LenConsec = 1
        for k in xrange(i+2, len(s)):
            if s[k] == c1:
                c1, c2 = c2, c1
                subLongest += 1
                c2LenConsec = 1
            elif s[k] == c2: 
                subLongest += 1
                c2LenConsec += 1
            else: 
                c1, c2 = c2, s[k]
                subLongest = c2LenConsec + 1
                c2LenConsec = 1
            result = max(subLongest, result)

        return result

s = Solution()
t = "aaaaabb"
print s.lengthOfLongestSubstringTwoDistinct(t)
