class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) < 2: return False
        pair = {'(':')', '[':']', '{':'}'}
        stack = []
        for c in s:
            if c in pair: stack.append(c)
            elif len(stack) == 0 or pair[stack.pop()] != c: return False

        return len(stack) == 0


sol = Solution()
print sol.isValid("{}[()]")