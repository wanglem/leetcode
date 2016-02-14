# 173. Binary Tree Iterator
# not too hard, in-order traversal with stack
# AVERAGE O(1) doesn't mean worst case!

# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        while root: 
            self.stack.append(root)
            root = root.left

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) > 0

    def next(self):
        """
        :rtype: int
        """
        if not self.hasNext: return None
        next = self.stack.pop()
        node = next.right
        while node:
            self.stack.append(node)
            node = node.left

        return next.val
