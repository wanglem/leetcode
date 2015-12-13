# 54.
class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if len(matrix) == 0: return []
        rs = []
        m = len(matrix)
        n = len(matrix[0])
        l = min(m, n)
        for layer in xrange(l/2):
            # get top
            i = j = layer
            for k in xrange(j,n-i-1): rs.append(matrix[i][k])

            # get right
            for k in xrange(i,m-i-1): rs.append(matrix[k][n-j-1])
            
            # get bottom
            for k in xrange(j, n-i-1): rs.append(matrix[m-i-1][n-k-1])

            # get left
            for k in xrange(i, m-i-1): rs.append(matrix[m-k-1][j])

        if l % 2 == 1:
            layer = l/2
            # one more horizontal line
            if n >= m:
                for k in xrange(layer, n - layer): rs.append(matrix[layer][k])
            # one more vertica line
            if m > n:
                for k in xrange(layer, m - layer): rs.append(matrix[k][layer])

        return rs

s = Solution()
t = [[1]]
for x in t:
    print x

print s.spiralOrder(t)