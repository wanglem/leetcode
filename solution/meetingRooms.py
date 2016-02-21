# 252. meeting with intervals, check if a person can attend all meetings
# basically find if there's any overlap
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: bool
        """
        sortedInterval = sorted(intervals, key=lambda x: x.start)
        for i in xrange(1, len(sortedInterval)):
            if sortedInterval[i].start < sortedInterval[i-1].end:
                return False
        return True