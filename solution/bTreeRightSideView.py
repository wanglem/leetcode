# 199. btree right side view, can do in two ways:
# 1. BFS, get last node (easier)
# 2. DFS, right -> left, keep track of max depth

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []
        result = []
        current = [root]
        while current:
            next = []
            result.append(current[-1].val)
            for x in current:
                if x.left: next.append(x.left)
                if x.right: next.append(x.right)

            current = next

        return result


