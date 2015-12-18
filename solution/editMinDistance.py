# 72.
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        # make sure word1 is shorter
        if len(word1) > len(word2):
            word1, word2 = word2, word1
        w1 = list(word1)
        w2 = list(word2)
        (w1, w2) = self._stripCommon(w1, w2)

        return self._minDistanceHelper(w1, w2)

    def _stripCommon(self, w1, w2):
        while len(w1) > 0:
            if w1[0] != w2[0]: break
            w1 = w1[1:]
            w2 = w2[1:]
        while len(w1) > 0:
            if w1[-1] != w2[-1]: break
            w1.pop()
            w2.pop()

        return (w1, w2)
    def _minDistanceHelper(self, w1, w2):
        (w1, w2) = self._stripCommon(w1[:], w2[:])
        wl1, wl2 = len(w1), len(w2)
        if wl1 == wl2:
            charReplaced = 0
            for i in xrange(wl1):
                if w1[i] != w2[i]: charReplaced += 1
            return charReplaced
        if wl1 == 0: return wl2

        minDistance = wl1 + wl2
        for i in xrange(wl2):
            if i < wl1 and w1[i] == w2[i]: continue
            distance = self._minDistanceHelper(w1, w2[:i] + w2[i+1:])
            if minDistance > distance:
                minDistance = distance

        return minDistance + 1

s = Solution()
a = "dinitrophenylhydrazine"
b = "dimethylhydrazine"
print s.minDistance(a, b)