# 290. word pattern
class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        words = s.split()
        if len(words) != len(pattern): return False
        ptow = {}
        wtop = {}
        for i in xrange(len(words)):
            if pattern[i] in ptow and words[i] != ptow[pattern[i]]:
                return False
            if words[i] in wtop and pattern[i] != wtop[words[i]]:
                return False
            ptow[pattern[i]] = words[i]
            wtop[words[i]] = pattern[i]

        return True