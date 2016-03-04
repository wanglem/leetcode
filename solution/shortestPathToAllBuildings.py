# 317. shortest path to all buildings, with obstacles
# 1: house, 2: obstacle, 0: path
# BFS, add (distance, adjacent) to queue, no obstacle. update whole map
# edge cases solutions:
# 1. all houses should at least reach to one common area
# 2. when calc shortest path, each path weight should be greater than total num of houses

from collections import deque
class Solution(object):
    def shortestDistance(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        path = [[0 for _ in xrange(len(grid[0]))] for _ in xrange(len(grid))]
        totalHouses = sum([sum([1 for symbol in row if symbol == 1]) for row in grid])
        firstTime = True
        for i in xrange(len(grid)):
            for j in xrange(len(grid[0])):
                if grid[i][j] == 1:
                    foundCommon = self.updatePathSum(i, j, path, grid, set(), firstTime)
                    if not foundCommon: return -1
                    firstTime = False

        shortest = 1
        for i in xrange(len(grid)):
            for j in xrange(len(grid[0])):
                if -1*path[i][j] < totalHouses: continue
                if shortest == 1: shortest = path[i][j]
                if shortest < path[i][j]:
                    shortest = path[i][j]

        return -1*shortest

    def updatePathSum(self, i, j, path, grid, visited, firstTime): 
        queue = deque([((i,j), 0)])
        visited.add((i,j))
        foundCommon = False
        while queue:
            pos, dis = queue.popleft()
            path[pos[0]][pos[1]] -= dis
            for nbor in self.getNeighbor(pos[0], pos[1], len(grid), len(grid[0])):
                if nbor not in visited and grid[nbor[0]][nbor[1]] == 0:
                    if path[nbor[0]][nbor[1]] != 0: foundCommon = True
                    queue.append(((nbor), dis+1))
                    visited.add(nbor)

        return firstTime or foundCommon

    def getNeighbor(self, i, j, rowCnt, colCnt):
        nbor = []
        if i > 0: nbor.append((i-1, j))
        if i < rowCnt-1: nbor.append((i+1, j))
        if j > 0: nbor.append((i, j-1))
        if j < colCnt-1: nbor.append((i, j+1))
        
        return nbor

a = [[1,1,1,1,1,1,1,0],
     [0,0,0,0,0,0,0,1],
     [1,1,1,1,1,1,0,1],
     [1,0,0,0,1,1,0,1],
     [1,0,1,1,1,1,0,1],
     [1,0,1,0,0,1,0,1],
     [1,0,1,1,1,1,0,1],
     [1,0,0,0,0,0,0,1],
     [0,1,1,1,1,1,1,0]]


s = Solution()
print s.shortestDistance(a)