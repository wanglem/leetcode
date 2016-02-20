# 224. basic calculator
# string expression, only +, - and parenthesis
# use a stack
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        (_, result) = self.calcPriority(s+')', 0)
        return result

    def calcPriority(self, s, i):
        result = 0
        op = '+'
        d = set('1234567890 ')
        while i < len(s) and s[i] != ')':
            if s[i] in ['+', '-']:
                op = s[i]
            elif s[i] == '(':
                (i, sub) = self.calcPriority(s, i+1)
                result = self.apply(result, op, sub)
            elif s[i] in d:
                (i, buf) = self.readInt(s, i)
                result = self.apply(result, op, buf)
            i += 1
        return (i, result)
    def readInt(self, s, i):
        buf = 0
        digit = set("1234567890 ")
        while i < len(s) and s[i] in digit:
            if s[i] != ' ':
                buf = buf*10 + int(s[i])
            i += 1
        return (i-1, buf)
    def apply(self, i, o, j):
        # i, o, j are strings
        if o == '+': return i+j
        return i-j
s = Solution()
print s.calculate('4-(5+3)+6-(9)')