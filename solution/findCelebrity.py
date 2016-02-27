# 277. find celebrity
# take 0, find set() A that 0 knows, celebrity must in A if any
# 1. for each candidate c, check all others o
# 2. if o knows c and c doesn't know o, continue
# if any c finishes step 1, c is the celebrity. terminate

# The knows API is already defined for you.
# @param a, person a
# @param b, person b
# @return a boolean, whether a knows b
# def knows(a, b):
class Solution(object):
    def findCelebrity(self, n):
        """
        :type n: int
        :rtype: int
        """
        candidate = []
        for i in xrange(1, n):
            if knows(0, i):
                candidate.append(i)
        if not candidate: return 0 if self.isCelebrity(0, n) else -1
        for c in candidate:
            if self.isCelebrity(c, n):
                return c
        return -1

    def isCelebrity(self, c, n):
        for i in xrange(n):
            if i == c: continue
            if not knows(i, c) or knows(c, i):
                return False
        return True
