# h index, find h numbers that each number greater than h
# counting sort
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        ranges = [0]*(len(citations)+1)
        for cit in citations:
            index = cit if cit < len(ranges) else -1
            ranges[index] += 1
        h = len(ranges) - 1
        count = 0
        while h >= 0:
            count += ranges[h]
            if count >= h:
                return h
            h -= 1
        return h

s = Solution()
print s.hIndex([3,0,6,1,5])