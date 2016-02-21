# 240. search 2-D matrix, left -> right sorted, top -> bottem sorted.
# solution 1: start from right top corner, go left or down
# 
# solution 2: divide and conquer, dive matrix to 4 part, compare center,
# if center > target, discard bottom right, 
# if center < target, discard top left,
# if center == target, return True
# (recursive)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        