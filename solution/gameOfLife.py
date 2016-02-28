# 289 game of life
# do in place trick: notice that all values are either 0 or 1, which only uses
# one bit of int, we can use second bit of int to record next state
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                count = self.getNeighborCount(i, j, board)
                if count == 3: state = 1
                elif count == 2: state = board[i][j]
                else: state = 0
                self.addNewState(i, j, state, board)

        self.updateToNewState(board)

    def getNeighborCount(self, i, j, board):
        count = 0
        for m in xrange(max(i-1, 0), min(i+1, len(board)-1)+1):
            for n in xrange(max(j-1, 0), min(j+1, len(board[0])-1)+1):
                if m == i and n == j: continue
                if self.getOldState(m, n, board) == 1:
                    count += 1
        return count

    def addNewState(self, i, j, state, board):
        board[i][j] |= (state << 1)
    def getNewState(self, i, j, board):
        return (board[i][j] & 2) >> 1
    def getOldState(self, i, j, board):
        return board[i][j] & 1
    def updateToNewState(self, board):
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                board[i][j] = self.getNewState(i, j, board)


s = Solution()
b = [
    [1,1],
    [1,0]
    ]
s.gameOfLife(b)
print b