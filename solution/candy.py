# 135.
class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        if len(ratings) == 0: return 0
        start = 0
        for i in xrange(len(ratings)):
            if ratings[i] < ratings[start]: start = i

        left = ratings[:start+1][::-1]
        right = ratings[start:]
        return sum(self._find(left)) + sum(self._find(right)) - 1

    def _find(self, r):
        state = [0 for _ in r]
        state[0] = 1
        for i in xrange(1, len(r)):
            if r[i] > r[i-1]:
                state[i] = state[i-1] + 1
            elif r[i] == r[i-1]:
                state[i] = 1
            else: # current is less than left, need assign less apple
                if state[i-1] == 1: state = self._addLeft(r, state, i-1)
                state[i] = 1
        return state

    def _addLeft(self, r, state, start):
        while start >= 0:
            state[start] += 1
            if r[start] >= r[start - 1]: break
            start -= 1
        return state


s = Solution()
r = range(2, 1000) + [1]
print s.candy(r)