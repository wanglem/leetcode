# 298. longest consequtive sequence in a path, must be increasing
# initialize curMax with 1, pre-check not root and return 0

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root: return 0
        return self.findPath(root, 1)

    def findPath(self, root, curMax):
        if not root: return curMax

        leftMax = rightMax = 1
        if root.left and root.val+1 == root.left.val:
            leftMax = curMax+1
        if root.right and root.val+1 == root.right.val:
            rightMax = curMax+1
        return max(curMax, self.findPath(root.left, leftMax), self.findPath(root.right, rightMax))