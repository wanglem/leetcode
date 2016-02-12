# 164.
# two steps: 1. merge ranges; 2. find gap!
# The Above solution was accepted, but could take O(nLogn) in worst case (all gaps are the same)
#
# Genius Solution:
# floorGap from the range is (maxValue-minValue) / (len-1) (The worst case above)
# Key Point:  we only need keep tracking min and max of each bucket, because if there's any value
# before min-max in this bucket, there must be an empty bucket elsewhere! So is the maxGap!
class Solution(object):

    def maximumGap(self, nums):
        if len(nums) < 2: return 0
        # merge ranges (non-overlapping), O(n)
        reaches = {nums[0]:nums[0]} # start -> end
        reached = {nums[0]:nums[0]} # end -> start
        for n in nums:
            if n+1 not in reaches and n-1 not in reached:
                reaches[n] = n
                reached[n] = n
                continue
            if n + 1 in reaches:
                reaches[n] = reaches[n+1] + 1
                reached[reaches[n+1]] = n
                del reaches[n+1]
            elif n - 1 in reached:
                reached[n] = reached[n-1]
                reaches[reached[n]] = n
                del reached[n-1]

        allRanges = sorted([(reached[k], k) for k in reached], key=lambda x:x[1])
        maxGap = 0
        preEnd = allRanges[0][1]
        for i in xrange(1, len(allRanges)):
            if allRanges[i][0] - preEnd < 2: continue
            maxGap = max(maxGap, allRanges[i][0] - preEnd)
            preEnd = allRanges[i][1]

        return maxGap

    def maximumGapBucket(self, nums):
        minV, maxV = min(nums), max(nums)
        numBuckets = len(nums) + 1
        bucketLen = (maxV - minV)*1.0 / len(nums)
        buckets = {i:[] for i in range(numBuckets)}

        for n in nums:
            bukIndex = int((n-minV) / bucketLen)
            recorded = buckets[bukIndex]
            if len(recorded) == 0:
                buckets[bukIndex] = [n]
            else:
                buckets[bukIndex] = [min(n, min(recorded)), max(n, max(recorded))]

        maxGap = 0
        pre = 0
        for i in xrange(numBuckets):
            if len(buckets[i]) == 0: continue
            if pre == 0:
                pre = max(buckets[i])
            else:
                maxGap = max(maxGap, min(buckets[i])-pre)
                pre = max(buckets[i])

        return maxGap



s = Solution()
n = [1,3,4,5,7]
print s.maximumGapBucket(n)