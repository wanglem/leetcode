# 87.
# A recursive BFS is a potential solution
# compare left1 with left2 and right1 with right2
# then compare left1 with right2 and right1 with left2

class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        if (len(s1) != len(s2)): return False
        if s1 == s2: return True
        s2Map = self._dictionarize(s2)
        for s1c in s1:
            if s1c not in s2Map: return False
        mid = len(s2) // 2
        if (self.isScramble(s1[:mid], s2[:mid]) and
            self.isScramble(s1[mid:], s2[mid:])):
            return True

        if (self.isScramble(s1[:mid], s2[-mid:]) and
            self.isScramble(s1[mid:], s2[:len(s1)-mid])):
            return True
        return False


    def _dictionarize(self, s):
        m = {}
        for i in s: m[i] = True

        return m

s = Solution()
print s.isScramble("abb", "bab")