class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        freq = {}
        for n in nums:
            freq[n] = freq.get(n, 0) + 1
        freqList = [(-freq[i], i) for i in freq]
        heapq.heapify(freqList)
        result = []
        for _ in range(0, k):
            result.append(heapq.heappop(freqList)[1])
        
        return result
