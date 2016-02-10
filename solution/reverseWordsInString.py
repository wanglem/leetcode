# 151. reverse words in a string
# Uhhhhhhhh, reverse s, then reverse each word again!!!!
# It's just that simple! I'm overthinking this too much.
# Pay attention to swap, do not swap all the way from i -> j, swap HALF!
class Solution(object):
    def noExtraSpace(self, s):
        """
        :type s: str
        :rtype: str
        """
        s = s.strip()
        l = list(s)
        i = j = 1
        while j < len(l):
            while j < len(l) and l[j] == ' ' and l[j-1] == ' ':
                j += 1
            l[i] = l[j]
            i += 1
            j += 1
        l = l[:i]
        n = len(l)
        for i in xrange(n/2):
            l[i], l[n-i-1] = l[n-i-1], l[i]

        i, j = 0, 0
        while j < n:
            i = j
            while j < n and l[j] != ' ':
                j += 1
            j -= 1
            m = j
            while m > i: 
                l[i], l[m] = l[m], l[i]
                i += 1
                m -= 1
            j += 2

        return "".join(l)

    def reverseWords(self, s):
        # return self.noExtraSpace(s)
        return self.extraSpace(s)

    def extraSpace(self, s):
        result = ""
        s = s.strip()
        i = len(s) - 1
        while i >= 0:
            while s[i] == ' ': i -= 1
            j = i
            while s[i] != ' ' and i != -1: i -= 1
            i += 1
            result += s[i:j+1] + " "
            i -= 2
        
        return result[:-1]


s = Solution()
print s.reverseWords("   a   b ")