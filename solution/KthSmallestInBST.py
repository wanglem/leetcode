# 230. find Kth smallest element in a BST
# follow up on frequently add/remove node, and get Kth
# each node keep track of it's number of children
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        lcount = self.count(root.left)
        if lcount == k-1: return root.val
        if lcount >= k:
            return self.kthSmallest(root.left, k)
        return self.kthSmallest(root.right, k-lcount-1)

    def count(self, root):
        if not root: return 0
        return 1+self.count(root.left)+self.count(root.right)