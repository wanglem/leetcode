# 186.
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: a list of 1 length strings (List[str])
        :rtype: nothing
        """
        s.reverse()
        pre = 0
        s.append(' ')
        for i in xrange(1, len(s)):
            if s[i] == " ":
                s[pre:i] = reversed(s[pre:i])
                pre = i+1
        s.pop()

s = Solution()
a = ["T", "h", "e"," ","s","k","y"," ","i","s"," ","B","l","u","e"]

s.reverseWords(a)

print a