# 294. flip game II, check first hand can win
# divide and conquer, split s into groups of consecqutive '+' with len > 1
# time complexity, n!!? n*(n-2)*(n-4)*...*3*1
# note: ususally when interviewer ask about time complexity, be cautious
# probably it's at least exponential
class Solution(object):
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        ls = list(s)
        loseCache = set()
        winCache = set()
        return self.check(ls, winCache, loseCache)

    def check(self, ls, winCache, loseCache):
        tmp = "".join(ls)
        if tmp in loseCache: return False
        if tmp in winCache: return True
        for i in xrange(len(ls)-1):
            if ls[i] == '+' and ls[i+1] == '+':
                ls[i], ls[i+1] = '-', '-'
                opponentCanWin = self.check(ls, winCache, loseCache)
                if opponentCanWin:
                    winCache.add("".join(ls))
                ls[i], ls[i+1] = '+', '+'
                if not opponentCanWin:
                    return True
        loseCache.add("".join(ls))
        return False

s = Solution()
t = ""
for _ in xrange(9):
    t += "+"
print s.canWin(t),