# 295. find median from a data stream
# using two heap, min and max
import heapq
class MedianFinder:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.minH = []
        self.maxH = []

    def addNum(self, num):
        """
        Adds a num into the data structure.
        :type num: int
        :rtype: void
        """
        if len(self.minH) == 0 or num >= self.minH[0]:
            heapq.heappush(self.minH, num)
        else:
            heapq.heappush(self.maxH, -1*num)

        if abs(len(self.maxH) - len(self.minH)) >= 2:
            biggerH, smallerH = self.minH, self.maxH
            if len(smallerH) > len(biggerH):
                biggerH, smallerH = smallerH, biggerH
            tmp = heapq.heappop(biggerH)
            heapq.heappush(smallerH, -1*tmp)

    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """
        minLen, maxLen = len(self.minH), len(self.maxH)
        if minLen == 0: return None
        if minLen > maxLen: return 1.0*self.minH[0]
        if minLen < maxLen: return -1.0*self.maxH[0]

        return (self.minH[0]-self.maxH[0])/2.0

# Your MedianFinder object will be instantiated and called as such:
# mf = MedianFinder()
# mf.addNum(1)
# mf.findMedian()