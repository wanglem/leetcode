# 253. list of meeting intervals, find min required meeting rooms
# if overlap, then need new meeting room, record meeting end time
# keep track of all rooms' end time, append new meeting to oldest available meeting end time
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if not intervals: return 0
        sortedIntervals = sorted(intervals, key=lambda x: x.start)
        roomEndTime = [sortedIntervals[0].end]
        for i in xrange(1, len(sortedIntervals)):
            if sortedIntervals[i].start < roomEndTime[0]:
                roomEndTime.append(sortedIntervals[i].end)
            else:
                roomEndTime[0] = sortedIntervals[i].end
            roomEndTime.sort()

        return len(roomEndTime)