# 316. remove duplicate letters while keeping lexicographical order
# greedy: use a stack keep each char, while current char is smaller than last one in stack
# and that last one in stack still has more, then pop it.
class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        def id(char):
            return ord(char)-ord('a')

        cntr = [0]*26
        for c in s:
            cntr[id(c)] += 1
        chars = []
        for char in s:
            if char not in chars:
                while len(chars) > 0 and char < chars[-1] and cntr[id(chars[-1])] > 0:
                    chars.pop()
                chars.append(char)
            cntr[id(char)] -= 1

        return "".join(chars)


s = Solution()
print s.removeDuplicateLetters("edebbed")