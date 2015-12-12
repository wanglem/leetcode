# 48
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        assert len(matrix) == len(matrix[0])
        n = len(matrix)
        for layer in xrange(n/2):
            for i in xrange(layer, n - layer - 1):
                c = [(layer,i),(i, n-layer-1),(n-layer-1,n-i-1),(n-i-1,layer)]
                self._swap4(c, matrix)
        return
                

    def _swap4(self, points, matrix):
        assert len(points) == 4
        previous = matrix[points[-1][0]][points[-1][1]]
        for i in xrange(len(points)):
            matrix[points[i][0]][points[i][1]], previous = previous, matrix[points[i][0]][points[i][1]]
        return


a = [[1,1,1,1],[2,2,2,2],[3,3,3,3],[4,4,4,4]]
a = [[1,2,3],[4,5,6],[7,8,9]]
for i in a:
    print i
s = Solution()
s.rotate(a)
print "break line"
for i in a:
    print i
