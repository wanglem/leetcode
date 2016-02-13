# 172. find trailing zeros in factorial
# each 2*5 leads to a 0, every 10 is a 0 itself. There are more 2s than 5s? like 4, 6, 8
# However, 25 contains 2 5s, so is 50, 75 has 3 5s..
# Still more 2s than 5s
# basically we should count number total 5s
# Tricky: how many 5s in 1 - n? answer if num_of_five = n/5
# but 25 is two 5s, so for each 25 we need add one more 5, that is num_of_five += n/25
# so is 75, now for each 75 we need add one more, num_of_five += n/75..
# keep going
# ...
class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        i, rs = 5, 0
        while i <= n:
            rs += n/i
            i *= 5
        return rs



s = Solution()
print s.trailingZeroes(50)