# 94. 
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# recursive is trivial, iterative?
class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None: return []

        left = self.inorderTraversal(root.left)
        right = self.inorderTraversal(root.right)

        return left + [root.val] + right

    def preorderTraversal(self, root):
        if root is None: return []

        left = self.preorderTraversal(root.left)
        right = self.preorderTraversal(root.right)

        return [root.val] + left + right

    def postorderTraversal(self, root):
        if root is None: return []

        left = self.postorderTraversal(root.left)
        right = self.postorderTraversal(root.right)

        return left + right + [root.val]




a = TreeNode('a')
b = TreeNode('b')
c = TreeNode('c')
d = TreeNode('d')
e = TreeNode('e')
f = TreeNode('f')
g = TreeNode('g')
h = TreeNode('h')
i = TreeNode('i')

f.left = b
f.right = h
b.left = a
b.right = d
d.left = c
d.right = e
h.left = g
h.right = i

s = Solution()
# [a, b, c, d, e, f, g, h, i]
# print s.inorderTraversal(f)
# [f, b, a, d, c, e, h, g, i]
# print s.preorderTraversal(f)
# [a, c, e, d, b, g, i, h, f]
print s.postorderTraversal(f)
