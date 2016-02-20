# 221. maximal square
# the idea is if i, j as right bottom corner can form a square, it's max size should
# be determined by square size of min[(i-1,j), (i, j-1), (i-1,j-1)]+1, upper left three
# adjacent nodes.
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix: return 0
        t = {'1':1, '0':0}
        size = [[t[x] for x in row] for row in matrix]
        maxSize = 0
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[0])):
                if i != 0 and j != 0 and size[i][j] != 0:
                    size[i][j] = min(size[i-1][j], size[i][j-1], size[i-1][j-1]) + 1
                maxSize = max(size[i][j], maxSize)

        return maxSize*maxSize

s = Solution()
m = [['1','1'],
    ['1','1']
    ]
print s.maximalSquare(m)