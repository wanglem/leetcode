# 51
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        rs = []
        for j in xrange(n):
            board = [[0]*n for _ in xrange(n)]
            self._markBoard(board, 0, j, 1)
            self._solveQueensHelper(board, 1, rs)
        return rs

    def _transformBoard(self, board):
        # first 0 in a row should be queen position
        rs = []
        for row in board:
            transformedRow = "".join(["Q" if x == 0 else '.' for x in row])
            rs.append(transformedRow)
        return rs

    def _solveQueensHelper(self, board, rowIndex, rs):
        if rowIndex == len(board): 
            rs.append(self._transformBoard(board))
            return
        row = board[rowIndex]
        for j in xrange(len(row)):
            found = False
            if row[j] == 0:
                self._markBoard(board, rowIndex, j, 1)
                self._solveQueensHelper(board, rowIndex+1, rs)
                self._markBoard(board, rowIndex, j, -1)

        return

    
    def _markBoard(self, board, row, column, offset = 1):
        # mark rest of the board, column and diagonal
        n = len(board)
        # mark row
        for i in xrange(0, n):
            if i == column: continue
            board[row][i] += offset
        # mark column
        for i in xrange(0, n):
            if i == row: continue
            board[i][column] += offset 
        # mark diagonal, lower right
        adj = abs(column - row)
        i, j = 0, 0
        if row < column:        j = adj
        else:                   i = adj
        while i < n and j < n:
            if not (i == row and j == column):
                board[i][j] += offset
            i, j = i+1, j+1
        # mark diagonal, lower left
        adj = abs(n - 1 - (row + column))
        i, j = 0, n - 1
        if row + column < n:    j -= adj
        else:                   i += adj 
        while i < n and j >= 0:
            if not (i == row and j == column):
                board[i][j] += offset
            i, j = i+1, j-1
