# 337. house robber III
# The thief has found himself a new place for his thievery again. 
# There is only one entrance to this area, called the "root." Besides 
# the root, each house has one and only one parent house. After a tour, 
# the smart thief realized that "all houses in this place forms a 
# binary tree". It will automatically contact the police if two directly-linked 
# houses were broken into on the same night.

# DP+DFS: on each level, either rob root or not rob root, return a tuple(x, y)
# x: max robbed with robbing root
# y: max robbed without robbing root
# recursive formula ^^^

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        