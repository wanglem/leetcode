# 155. stack with track of minimum value, good design question
# for minimum value tracking, keep a non increasing order of pushed values
# worst case stack capacity would be doubled
class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min = []
        self.all = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.all.append(x)
        if not self.min or self.min[-1] >= x:
            self.min.append(x) 

    def pop(self):
        """
        :rtype: nothing
        """
        if not self.all: return
        if self.all.pop() == self.min[-1]:
            self.min.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.all[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min[-1]