# 149. max points on a line, 2D array
# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

# solution: reverse thinking, instead of processing line by line, find unique identifier
# of each line (point, slope), and add each points to it's line

# implementation is not so hard, question: can a line not pass center of node?? e.g.
# 1 2 3
# 4 5 6
# 7 8 9
# so is there a line connects 4 and 9?
class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        pcount = {}
        for i in xrange(len(points)):
        	slope = 0 # horizontal line
        	pcount[(0, i, slope)] = 0
        for j in xrange(len(points[0])):
        	slope = 1
        	pcount[(j, 0, slope)] = 1