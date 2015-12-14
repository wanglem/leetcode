# 57.
# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

# find insert position, sort by start
# get new list, append newInterval
# if new list > 2, fix merge issue of last two in new list
# merge rest

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        insertIndex = len(intervals)
        for i in xrange(len(intervals)):
            if intervals[i].start >= newInterval.start:
                insertIndex = i
                break
        rs = [Interval(x.start, x.end) for x in intervals[:insertIndex]] + [newInterval]
        if len(rs) > 1:
            if rs[-1].start <= rs[-2].end:
                rs[-2].end = max(rs[-1].end, rs[-2].end)
                rs.pop()
        i = insertIndex
        while i < len(intervals):
            if rs[-1].end < intervals[i].start:
                rs.extend([Interval(x.start, x.end) for x in intervals[i:]])
                break
            elif rs[-1].end == intervals[i].start:
                rs[-1].end = intervals[i].end
                rs.extend([Interval(x.start, x.end) for x in intervals[i+1:]])
                break
            else:
                rs[-1].end = max(rs[-1].end, intervals[i].end)
            i += 1

        return rs
            



i1 = Interval(1,5)
i2 = Interval(6,7)
i3 = Interval(9,10)

t = [i1,i2,i3]
t = [i1]
n = Interval(0,3)
s = Solution()
for x in s.insert(t, n):
    print x.start, x.end