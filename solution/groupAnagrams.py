# 49
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        if not strs: return []

        strs.sort()
        signatureList = {self._anaSig(strs[0]): [strs[0]]}
        for st in strs[1:]:
            sig = self._anaSig(st)
            if sig not in signatureList: signatureList[sig] = [st]
            else: signatureList[sig].append(st)

        return signatureList.values()

    def _anaSig(self, s):
        if not s: return ""
        s = "".join(sorted(list(s)))
        sig = s[0]
        count = 1
        for i in xrange(1, len(s)):
            if s[i] == s[i-1]: count += 1
            else: 
                sig += str(count) + s[i]
                count = 1
        if count > 1: sig += str(count)

        return sig

s = Solution()
print s._anaSig("solids")