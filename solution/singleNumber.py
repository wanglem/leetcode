# 136
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        visited = {}
        result = 0
        for n in nums:
            if n in visited:
                result -= n
            else: 
                result += n
                visited[n] = True

        return result
    def _singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        for n in nums:
            result ^= n
        return result

    def _a(self, nums):
        result = 0
        return reduce(lambda x,y:x^y, nums)

a = [1,1,3,5,4,4,3]
s = Solution()
print s._a(a)
