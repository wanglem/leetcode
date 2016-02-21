# 247. find all numbers with length n
# for each 1,6,9,8,0, append it to front and end, and recursive find k-2
# note that can not append 0 in front on first level
class Solution(object):
    def findStrobogrammatic(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        return self._find(n, n)


    def _find(self, n, k):
        lut = {"1":"1", "6":"9", "8":"8", "9":"6", "0":"0"}
        if k == 1: return ["1", "8", "0"]
        if k == 0: return [""]
        candidate = ["1","8","6", "9"]
        if n > k: candidate.append("0")
        allNum = []
        rst = self._find(n, k-2)
        for n in candidate:
            allNum.extend([n+rs+lut[n] for rs in rst])

        return allNum

s = Solution()
print s.findStrobogrammatic(3)