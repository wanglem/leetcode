# 127. word Ladder
from collections import deque
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        if beginWord == endWord: return 1
        visited = set()
        queue = deque([(beginWord, 1)])
        candidate = "abcdefghijklmnopqrstuvwxyz"
        while queue:
            (word, length) = queue.popleft()
            for i in xrange(len(word)):
                for c in candidate:
                    newWord = word[:i] + c + word[i+1:]
                    if newWord == endWord: return length + 1
                    if newWord not in visited and newWord in wordList:
                        queue.append((newWord, length + 1))
                        visited.add(newWord)

        return 0


dic = ["hot","dot","dog","lot","log"]
b = "hit"
e = "hit"

s = Solution()
print s.ladderLength(b, e, dic)