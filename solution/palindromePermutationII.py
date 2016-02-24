# 267. all permutation that's a palindrome
class Solution(object):
    def generatePalindromes(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        freqs = self.charFreqs(s)
        if not self.canGeneratePalindrome(freqs):
            return []
        single = ""
        doubles = ""
        base = ord('a')
        for i in xrange(len(freqs)):
            if freqs[i] == 0: continue
            if freqs[i] % 2 == 1: single = chr(i+base)
            for j in xrange(freqs[i]/2):
                doubles += chr(i+base)
        half = self.getAllPermutations(doubles)
        return [h+single+h[::-1] for h in half]

    def getAllPermutations(self, doubles):
        if len(doubles) == 1: return [doubles]
        result = [doubles]
        for i in xrange(1, len(doubles)):
            if doubles[0] == doubles[i]: continue
            childPerms = self.getAllPermutations(doubles[1:i]+doubles[0]+doubles[i+1:])
            result.extend([doubles[i]+child for child in childPerms])

        return result

    def canGeneratePalindrome(self, freqs):
        return len([x for x in freqs if x % 2 != 0]) < 2

    def charFreqs(self, s):
        base = ord('a')
        freqs = [0]*26
        for char in s:
            freqs[ord(char)-base] += 1
        return freqs

st = "aaabbcc"
s = Solution()
print s.generatePalindromes(st)