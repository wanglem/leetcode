# 318. max product of two words that share no common char
# bit array that records words signature (definitely faster!)
# or prime number that holds signature (slower but also works and interesting!)

class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        maxProduct = 0
        sigArr = [self.hash(w) for w in words]
        for i in xrange(len(sigArr)):
            for j in range(i+1, len(sigArr)):
                if not self.hasGCD(sigArr[i], sigArr[j]):
                    maxProduct = max(maxProduct, len(words[i])*len(words[j]))
        return maxProduct

    def hasGCD(self, i, j):
        if i > j: i, j = j, i
        if i == 1: return False
        if j % i == 0:
            return True
        return self.hasGCD(i, j%i)

    def hash(self, word):
        sig = 1
        for c in set(word):
            sig *= self.get26Prime()[ord(c)-ord('a')]
        return sig

    def get26Prime(self):
        return [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]

    def hash2(self, word):
        sig = 0
        for c in word:
            sig |= 1 << (ord(c)-ord('a'))
        return sig

    def maxProductBit(self, words):
        maxProduct = 0
        sigArr = [self.hash2(w) for w in words]
        for i in xrange(len(sigArr)):
            for j in range(i+1, len(sigArr)):
                if not (sigArr[i] & sigArr[j]):
                    maxProduct = max(maxProduct, len(words[i])*len(words[j]))
        return maxProduct


s = Solution()
print s.maxProductBit(["a", "aa", "aaa", "aaaa"])
