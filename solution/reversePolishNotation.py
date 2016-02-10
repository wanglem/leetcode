# 150.
# ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
# ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
# op: [+, -, *, /]
# pretty straightforward, use a stack

# some interesting points:
# 1. 6 / -132 == -1?? hehe
# 2. "1".isdigit() -> True, "+1".isdigit() -> False
class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        def isInt(s):
            if s[0] == "+" or s[0] == "-":
                return s[1:].isdigit()
            return s.isdigit()

        stack = []
        for t in tokens:
            if isInt(t):
                stack.append(int(t))
            else:
                r = stack.pop()
                l = stack.pop()
                stack.append(self._applyOp(l, r, t))

        return stack.pop()

    def _applyOp(self, left, right, op):
        result = 0
        if op == '+': result = left+right
        if op == '*': result = left*right
        if op == '-': result = left-right
        if op == '/': result = left/right

        return result

s = Solution()
t = ["4", "13", "5", "/", "+"]
t = ["2", "1", "+", "3", "*"]
t = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
print s.evalRPN(t)