# 320. generalized abbreviation
# word -> 
# ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", 
# "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
# originally thinking divide and conquer, partition word into two groups and a count in middle
# recursively abbreviate left and right part then merge
# but actually I don't need abbrevidate left part, otherwise it will have duplicates:
# wordd -> 1ordd, so when you have wor1d, you dont want to abbr `wo` 
# so only abbr right side, sort of like DFS.
# DFS DFS DFS, abbreviate left and recursive on right!
class Solution(object):
    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        return self.abbreviate(word) + [word]

    def abbreviate(self, word):
        if not word: return []
        result = []
        for i in xrange(0, len(word)):
            for j in xrange(i, len(word)):
                p1, mid, p2 = self.partition(word, i, j)
                result.append(p1+mid+p2)
                rightAbbrs = self.abbreviate(p2)
                result.extend([p1+mid+right for right in rightAbbrs])

        return result

    def partition(self, word, window, end):
        cnt = str(window+1)
        p1 = word[:end-window]
        p2 = word[end+1:]
        if len(p1) > 0:
            cnt = p1[-1]+cnt
            p1 = p1[:-1]
        if len(p2) > 0:
            cnt = cnt+p2[0]
            p2 = p2[1:]

        return p1, cnt, p2


s = Solution()
b = s.generateAbbreviations("word")
print b
print len(b)
print len(set(b))
print "2r1"