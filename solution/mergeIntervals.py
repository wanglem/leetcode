# 56.
# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if not intervals: return []
        intervals.sort(key = lambda x: x.start)

        rs = [Interval(intervals[0].start, intervals[0].end)]
        for i in intervals[1:]:
            if rs[-1].end < i.start:
                rs.append(Interval(i.start, i.end))
            elif rs[-1].end == i.start:
                rs[-1].end = i.end
            elif rs[-1].end > i.start and rs[-1].end < i.end:
                    rs[-1].end = i.end

        return rs


i1 = Interval(1,4)
i2 = Interval(1,5)
i3 = Interval(9,10)

t = [i3,i2,i1]
s = Solution()
for i in s.merge(t):
    print i.start, i.end