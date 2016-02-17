# 214. append shortest string in front of s and make s palindrome
# aaeceaaa
# made a trick and passed OJ, basically more agressive jumping.
# if the fisrt match does not exist in previous match, then direct jump to next instead
# of shift index by 1
class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        srev = s[::-1][:len(s)]
        longest = 1
        i = 0
        while i < len(srev):
            m, n = 0, i
            while n < len(srev) and srev[n] == s[m]:
                m, n = m+1, n+1
            if n == len(srev): return srev[:i] + s
            occurance = set(s[:m])
            if srev[m] not in occurance: i += max(m, 1)
            else: i += 1

        return ""


s = Solution()
a = "aabba"
print s.shortestPalindrome(a)