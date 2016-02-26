# 272. find K closest values to target in a BST
# find the closet node, and find K-1 values around that node
# Definition for a binary tree node.
# Morris Traversal:
# 1. if root has left, go to left node's most right node, point that node.right to root
#    then let root = root.left, continue doing step 1
# 2. when root has not left (right branch pointed already), print value, go to root.right
# 3. then we should encounter step 1 again, but now we check if root's left's right node 
#    is root itself, if yes, set tmp.right=None, now root go to right.
# Anyway, just check the code below.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
from collections import deque
class Solution(object):
    def closestKValues(self, root, target, k):
        """
        :type root: TreeNode
        :type target: float
        :type k: int
        :rtype: List[int]
        """
        i = 0
        bst = self.flattenBST(root)
        while i < len(bst)-1:
            if abs(bst[i]-target) < abs(bst[i+1]-target):break
            i += 1
        result = [bst[i]]
        lo , hi = i-1, i+1
        while k > 1:
            if lo < 0:
                result.append(bst[hi])
                hi += 1
            elif hi >= len(bst):
                result.append(bst[lo])
                lo -= 1
            else:
                if abs(bst[lo]-target) > abs(bst[hi]-target):
                    result.append(bst[hi])
                    hi += 1
                else:
                    result.append(bst[lo])
                    lo -= 1
            k -= 1
        return result

    def flattenBST(self, root):
        if not root: return []
        left = self.flattenBST(root.left)
        right = self.flattenBST(root.right)
        return left + [root.val] + right

    def searchBSTWindow(self, root, target, k):
        # keep K window and morris traversal
        window = deque()
        while root:
            if root.left:
                tmp = root.left
                while tmp.right and tmp.right != root:
                    tmp = tmp.right
                if tmp.right:
                    tmp.right = None
                else:
                    tmp.right = root
                    root = root.left
                    continue
            diff = abs(root.val-target)
            if len(window) < k:
                window.append((root.val, diff))
            elif window[0][1] > diff:
                window.popleft() 
                window.append((root.val, diff))
            else:
                break

            root = root.right

        return [w[0] for w in window]


a = TreeNode(1)
b = TreeNode(2)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(5)
f = TreeNode(6)
g = TreeNode(7)
h = TreeNode(8)
i = TreeNode(9)
f.left, f.right = d, h
d.left, d.right = c, e
h.left, h.right = g, i
c.left = b
s = Solution()
print s.searchBSTWindow(f, 4.3, 5)
# print s.closestKValues(f, 4.3, 5)
