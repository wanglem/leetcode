# 331. verify preorder serialization of a binary tree
# similar with iterative method traversal tree
# if nothing in stack and still node in preorder then False
# if nothing in preorder but node in stack then False
class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        if not preorder: return False
        if preorder[0] == '#' and len(preorder) == 1: return True
        stack = []
        reader = self.readnext(preorder)
        for node in reader:
            if node is None: return False
            stack.append(node)
            while len(stack) > 2 and stack[-1] == stack[-2] == '#' and stack[-3] != '#':
                for _ in xrange(3):
                    stack.pop()
                if stack: stack.append('#')
            if not stack: break
        return next(reader) is None

    def readnext(self, ser):
        buf = ""
        ser += ','
        for i in xrange(len(ser)):
            if ser[i] != ',':
                buf += ser[i]
            else:
                yield buf
                buf = ""
        yield None

s = Solution()
ser = "9,3,4,#,#,1,#,#,2,#,6,#,#"
print s.isValidSerialization(ser)
