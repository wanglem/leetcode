class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # check row
        dboard = [[ 0 if c == '.' else int(c) for c in row ] for row in board]
        for row in dboard:
            m = {}
            for cell in row:
                if m.get(cell, False) or cell > 9 or cell < 0:
                    return False
                if cell != 0: m[cell] = True


        # check column
        for column in xrange(0, 9):
            m = {}
            for row in xrange(0, 9):
                cell = dboard[row][column]
                if m.get(cell, False) or cell > 9 or cell < 0:
                    return False
                if cell != 0: m[cell] = True

        # check board
        for boardNum in xrange(0, 9):
            m = {}
            rowStart = boardNum/3*3
            for i in xrange(rowStart, rowStart+3):
                colStart = boardNum%3*3
                for j in xrange(colStart,colStart+3):
                    cell = dboard[i][j]
                    if m.get(cell, False) or cell > 9 or cell < 0:
                        return False
                    if cell != 0: m[cell] = True

        return True

s = Solution()
print s.isValidSudoku([".87654321","2........","3........","4........","5........","6........","7........","8........","9........"])