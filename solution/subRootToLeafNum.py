# 129. 
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        if root is None: return 0

        tupSeq = self._sumNums(root)
        return sum([tup[1] for tup in tupSeq])

    def _sumNums(self, root):

        if root.left is None and root.right is None:
            return [(1, root.val)]

        tupSeq = []
        if root.left:
            leftSeq = self._sumNums(root.left)
            tupSeq.extend(leftSeq)
        if root.right:
            rightSeq = self._sumNums(root.right)
            tupSeq.extend(rightSeq)

        return [(tup[0]*10, root.val*tup[0]*10+tup[1]) for tup in tupSeq]




t1 = TreeNode(1)
t2 = TreeNode(2)
t3 = TreeNode(3)
t1.left = t2
t1.right = t3

s = Solution()
print s.sumNumbers(t1)