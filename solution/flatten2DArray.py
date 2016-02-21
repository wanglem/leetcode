# 251. flatten 2D array
# hasNext should be Quick and Neat
# put all heavylifting to next(), make a necessary helper method for init and next
class Vector2D(object):

    def __init__(self, vec2d):
        """
        Initialize your data structure here.
        :type vec2d: List[List[int]]
        """
        self.size = [len(x) for x in vec2d]
        self.vec2d = iter(vec2d)
        self.buf = iter([])
        if self.size: self.buf = iter(next(self.vec2d))
        self._nextRow()

    def _nextRow(self):
        while self.size and self.size[0] == 0:
            self.size = self.size[1:]
            if not self.size: break
            self.buf = iter(next(self.vec2d))

    def next(self):
        """
        :rtype: int
        """
        if not self.hasNext():
            return None
        self.size[0] = self.size[0]-1
        tmp = next(self.buf)
        self._nextRow()
        return tmp

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.size and self.size[0] > 0

s = Vector2D([[1,2],[3],[4,5,6]])
while s.hasNext():
    print s.next()

