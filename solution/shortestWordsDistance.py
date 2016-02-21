# 245. shortest word distance, 
# word1 and word2 can be the same, but still two index
class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        w1, w2 = [], []
        for i in xrange(len(words)):
            if words[i] == word1: w1.append(i)
            elif words[i] == word2: w2.append(i)

        if word1 == word2:
            return min([w1[i]-w1[i-1] for i in xrange(1, len(w1))])

        minD = len(words) - 1
        # if len(w1) > len(w2): w1, w2 = w2, w1
        i, j = 0, 0
        while i < len(w1) and j < len(w2):
            minD = min(minD, abs(w2[j]-w1[i]))
            if minD == 1: break
            if w1[i] > w2[j]: j += 1
            else: i += 1

        return minD

s = Solution()
w = ["practice", "makes", "perfect", "coding", "makes"]
print s.shortestWordDistance(w, 'makes', 'practice')