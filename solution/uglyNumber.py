# 263. ugly number
# struggled a bit on clean implementation, good to review
class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0: return False
        for divisor in [2,3,5]:
            while num%divisor == 0:
                num /= divisor
        
        return num == 1