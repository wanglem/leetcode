# 329. longest increasing path in a matrix
# DFS, for each cell find longest path
# note we should use recursive DFS instead of BFS so that we can cache longest
# path for each node when searching!
# also, if other cell meets any marked cell, it can return immediately because
# the longest already being known and it's definitely in increasing order!
from collections import deque
class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        cache = [[0 for _ in matrix[0]] for _ in matrix]
        longest = 0
        for i in xrange(len(matrix)):
            for j in xrange(len(matrix[0])):
                longest = max(longest, self.dfs(i, j, matrix, cache, set()))
        return longest

    def dfs(self, row, col, matrix, cache, visited):
        if cache[row][col] != 0:
            return cache[row][col]
        visited.add((row, col))
        maxLen = 0
        for i, j in self.getNbor(row, col, len(matrix), len(matrix[0])):
            if (i, j) in visited: continue
            if matrix[i][j] > matrix[row][col]:
                curLen = self.dfs(i, j, matrix, cache, visited)
                maxLen = max(maxLen, curLen)

        cache[row][col] = maxLen + 1
        return cache[row][col]


    def getNbor(self, i, j, rowCnt, colCnt):
        nbors = []
        if i > 0: nbors.append((i-1, j))
        if i < rowCnt-1: nbors.append((i+1, j))
        if j > 0: nbors.append((i, j-1))
        if j < colCnt-1: nbors.append((i, j+1))

        return nbors
nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
s = Solution()
print s.longestIncreasingPath(nums)