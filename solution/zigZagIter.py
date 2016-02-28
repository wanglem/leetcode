# 281. zig zag iterator
# instead of keeping maxedout indexes, use a queue, do not append when maxed out
from collections import deque
class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.vecs = []
        if v1: self.vecs.append(v1)
        if v2: self.vecs.append(v2)
        self.ps = deque([(i, 0) for i in xrange(len(self.vecs))])

    def next(self):
        """
        :rtype: int
        """
        if not self.hasNext(): return False
        (vecIndex, valIndex) = self.ps.popleft()
        result = self.vecs[vecIndex][valIndex]
        if valIndex != len(self.vecs[vecIndex]) - 1:
            self.ps.append((vecIndex, valIndex+1))
        return result

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.ps) > 0

v1 = [1, 2]
v2 = [3, 4, 5, 6]

s = ZigzagIterator(v1, v2)
while s.hasNext():
    print s.next()