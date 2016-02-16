# 212. word search II, search a word in a 2D array
# still use dfs to search a word in array, but could also use some optimization
# Ideas:
# 1. record bad words, if another words shares any common prefix, then no need search. I used
#    a set, but answer was using a trie, could be more efficient.
# 2. pre record each char's location, no need go through all 2d array for each word
#    to find start location
class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        loc = {}
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                pins = loc.get(board[i][j], [])
                pins.append((i, j))
                loc[board[i][j]] = pins

        result = []
        badPrefix = set()
        for word in words:
            if self.isBadPrefix(word, badPrefix):
                continue
            startPins = loc.get(word[0], [])
            found = False
            for startPin in startPins:
                if self.find(0, word, startPin, dict(), board):
                    result.append(word)
                    found = True
                    break
            if not found: badPrefix.add(word)
        return result

    def find(self, i, word, loc, visited, board):
        r, c = loc
        if r < 0 or r >= len(board): return False
        if c < 0 or c >= len(board[0]): return False
        if i == len(word): return True
        if loc[0] in visited and visited[loc[0]] == loc[1]:
            return False
        if board[r][c] != word[i]: return False
        visited[r] = c
        # search up
        found = self.find(i+1, word, (r-1, c), visited, board)
        if found: return True
        # search right:
        found = self.find(i+1, word, (r, c+1), visited, board)
        if found: return True
        # search down
        found = self.find(i+1, word, (r+1, c), visited, board)
        if found: return True
        # search left
        found = self.find(i+1, word, (r, c-1), visited, board)
        if found: return True
        del visited[r]
        return False

    def isBadPrefix(self, prefix, badWords):
        for badWord in badWords:
            if len(prefix) > len(s):continue
            if prefix == s[:len(prefix)]: return True
        return False

s = Solution()
a = [['a', 'b', 'c'], ['b', 'd', 'b'], ['c', 'f', 'a']]
print s.findWords(a, ["abcd"])