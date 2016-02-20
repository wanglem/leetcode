# 227. Calculator II, include () and +-*/, also white spaces
# go though all element in s
# if finish reading a int, if previous operator is * or /, calculate last expression
# if not (previous op is + or -), append this int to stack
# so the int stack and op stack should always handle + and -
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        (_, result) = self._cal(s, 0)
        return result

    def _cal(self, s, i):
        stack = []
        op = []
        d = set("12354567890")
        while i < len(s) and s[i] != ')':
            if s[i] == '(':
                (i, sub) = self._cal(s, i+1)
                stack.append(sub)
            elif s[i] in d:
                (i, buf) = self._readInts(s, i)
                if op and op[-1] in set("*/"):
                    stack[-1] = self._apply(stack[-1], op.pop(), buf)
                else:
                    stack.append(buf)
            elif s[i] in set("*/"):
                op.append(s[i])
            elif s[i] in set("+-"):
                self._aggregate(stack, op)
                op.append(s[i])
            i += 1

        self._aggregate(stack, op)
        return (i, stack[0])

    def _aggregate(self, stack, ops):
        # ops should be either + or -
        sub = stack.pop()
        while stack:
            sub = self._apply(stack.pop(), ops.pop(), sub)
        stack.append(sub)

    def _readInts(self, s, i):
        d = set("12354567890")
        buf = 0
        while i < len(s) and s[i] in d:
            buf = buf*10+int(s[i])
            i += 1

        return (i-1, buf)

    def _apply(self, i, op, j):
        exp = {'+': i+j,'-': i-j,'*': i*j}
        if op in exp: 
            return exp[op]
        return i/j

s = Solution()
print s.calculate("100000000/1/2/3/4/5/6/7/8/9/10")