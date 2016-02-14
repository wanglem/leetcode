# 179. largest number
# If something is getting too complicated than you think, there's probably something wrong
# this is actually quite simple, write a comparator
# easy for 7 > 345, but how about 123 vs 1234?
# pay attention to how it's sorted, '1234'+'123' > '123'+'1234', right?
class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        result = sorted(map(str, nums), cmp=lambda x, y: -1 if x+y>y+x else 1)
        return '0' if result[0]== '0' and result[-1] == '0' else ''.join(result)

s = Solution()

n = [0,0,1]

print s.largestNumber(n)