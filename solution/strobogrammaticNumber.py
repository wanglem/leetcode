# 246. number looks like the same upside down. 69, 818
class Solution(object):
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        lut = {"1":"1", "6":"9", "9":"6", "8":"8", "0":"0"}
        i, j = 0, len(num)-1 
        while i <= j:
            if num[i] not in lut or lut[num[i]] != num[j]:
                return False
            i, j = i+1, j-1

        return True

s = Solution()
print s.isStrobogrammatic("689")