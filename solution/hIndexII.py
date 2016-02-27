# 275. citations are sorted, optimize
# can use binary search
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        lo, hi = 0, len(citations)
        while lo < hi:
            mid = (hi+lo)/2
            if citations[mid] >= len(citations)-mid:
                hi = mid
            else:
                lo = mid+1

        return len(citations)-lo

s = Solution()
print s.hIndex([0,0,0])