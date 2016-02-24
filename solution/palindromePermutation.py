# 266. if a string's permutation is palindrome
class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        freqs = {}
        for char in s:
            freqs[char] = freqs.get(char, 0) + 1
        odds = 0
        for char in freqs:
            if freqs[char] % 2 != 0:
                odds += 1
                if odds == 2: return False

        return True