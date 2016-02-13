# 168. covert number to chars
# e.g. 1 -> A, 26 -> Z, 26+1 -> AA 
# 26 + 26 -> AZ, 26 + 26 + 1 -> BA
class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        low = ord('A')
        result = ""
        while n > 0:
            result = chr((n-1)%26 + low) + result
            n = (n-1)/26

        return result


s = Solution()
print s.convertToTitle(27)
