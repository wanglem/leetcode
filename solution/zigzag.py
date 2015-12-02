class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1: return s
        rowCache = [[] for _ in xrange(numRows)]
        j, offset = 0, 1
        for i in xrange(0,len(s)):
            if j == 0:              offset =  1
            elif j == numRows - 1:  offset = -1
            rowCache[j].append(s[i])
            j += offset

        return "".join(["".join(row) for row in rowCache])




sol = Solution()
print sol.convert("AB", 1)