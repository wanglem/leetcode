# 258. add digits
# add all digits in a integer until one last digit left
# 28 = 2+8 = 11 = 1+1 = 2
# periodically occur, every 9 it increments 1
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        