# 130.
# solution:
# Consider: if an O or area of Os are not surronded by X means,
# it must connects to one boarder!
# so use an O on boarder and bfs search all its adjacent O, they all not surronded. 
# Then just mark others to X.
from collections import deque
class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        m = len(board)
        if m < 1: return
        n = len(board[0])
        marked = [[False for _ in xrange(n)] for _ in xrange(m)]
        
        for j in xrange(1, n): # mark top
            if board[0][j] == 'O': self.mark(0, j, board, marked)
        for i in xrange(1, m): # mark right
            if board[i][-1] == 'O': self.mark(i, n-1, board, marked)
        for j in xrange(0, n-1): # bottom
            if board[-1][j] == 'O': self.mark(m-1, j, board, marked)
        for i in xrange(0, m-1):
            if board[i][0] == 'O': self.mark(i, 0, board, marked)

        for i in xrange(m):
            for j in xrange(n):
                if not marked[i][j]:
                    board[i][j] = 'X'


    def mark(self, rowIndex, colIndex, bd, marked):
        queue = deque([(rowIndex,colIndex)])
        while queue:
            (i, j) = queue.popleft()
            marked[i][j] = True
            if i > 0 and not marked[i-1][j] and bd[i-1][j] == 'O':
                queue.append((i-1, j))
            if i < len(bd)-1 and not marked[i+1][j] and bd[i+1][j] == 'O':
                queue.append((i+1, j))
            if j > 0 and not marked[i][j-1] and bd[i][j-1] == 'O':
                queue.append((i, j-1))
            if j < len(bd[0])-1 and not marked[i][j+1] and bd[i][j+1] == 'O':
                queue.append((i, j+1))

        return marked



s = Solution()
a = [
['X', 'X', 'X', 'X'],
['X', 'O', 'O', 'X'],
['X', 'X', 'O', 'X'],
['X', 'O', 'X', 'X']
]
s.solve(a)
print a