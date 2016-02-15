# 200. adjacent node only goes to up, down, left, right, no diagonal.
# for each element, BFS and mark dp True if 1, skip if True
# 
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid) == 0: return 0
        count = 0
        mark = [[False for _ in grid[0]] for _ in grid]
        for i in xrange(len(grid)):
            for j in xrange(len(grid[0])):
                if grid[i][j] == '1' and not mark[i][j]:
                    count += 1
                    mark = self.bfsMark(i, j, grid, mark)
        return count

    def bfsMark(self, i, j, grid, mark):
        stack = [(i, j)]
        while stack:
            (k, l) = stack.pop()
            if grid[k][l] == '0' or mark[k][l]: continue
            if k < len(grid) - 1 : stack.append((k+1, l))
            if k > 0: stack.append((k-1, l))
            if l > 0: stack.append((k, l-1))
            if l < len(grid[0]) - 1: stack.append((k, l+1))

            mark[k][l] = True
        return mark

s = Solution()
grid = [
    ['1','0','1','1','1'],
    ['1','0','1','0','1'],
    ['1','1','1','0','1']
]
print s.numIslands(grid)