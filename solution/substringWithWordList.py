class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        repo = {}
        for w in words:
            count = repo.get(w, 0)
            count += 1
            repo[w] = count
        wordLen = len(words[0])
        wordsLen = len(words) * wordLen
        result = []
        for i in xrange(len(s) - wordsLen+1):
            if self._match(s[i: wordsLen+i], repo.copy(), wordLen):
                result.append(i)

        return result

    def _match(self, s, repo, step):
        i = 0
        while i < len(s):
            if s[i:step+i] not in repo: return False
            count = repo.get(s[i:step+i])
            if count == 0: return False
            repo[s[i:step+i]] = count-1
            i += step
        return True

sol = Solution()
s = "barfoothefoobarman"
words = ["foo", "bar"]
print sol.findSubstring(s, words)