# 270. given bst, find closet value to target
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def closestValue(self, root, target):
        """
        :type root: TreeNode
        :type target: float
        :rtype: int
        """
        if not root: return None
        return self.searchCloset(root, target, root.val)


    def searchCloset(self, root, target, closet):
        if not root: return closet
        if abs(target-root.val) < abs(target-closet):
            closet = root.val
        if target > root.val:
            return self.searchCloset(root.right, target, closet)
        return self.searchCloset(root.left, target, closet)

a1 = TreeNode(1)
a2 = TreeNode(2)
a1.right = a2
s = Solution()
print s.closestValue(a1, 3.13)