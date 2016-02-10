# 145.
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None: return []

        stack = []
        visited = set()
        leftNode = root
        while leftNode:
            stack.append(leftNode)
            leftNode = leftNode.left

        result = []
        while stack:
            node = stack.pop()
            rightToLeft = node.right
            if rightToLeft and rightToLeft not in visited:
                visited.add(rightToLeft)
                stack.append(node)
                while rightToLeft:
                    stack.append(rightToLeft)
                    rightToLeft = rightToLeft.left
            else:
                result.append(node.val)

        return result

a1 = TreeNode(1)
a2 = TreeNode(2)
a3 = TreeNode(3)
a1.right = a3
a1.left = a2
s = Solution()
print s.postorderTraversal(a1)