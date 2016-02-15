# 204. count number of primes below n
# hashtable, mark 
# when mark multiple of x is not Prime, can terminate by sqrt(n), because
# 2*6 == 6*2 == 12, if x*x == n then x <= sqrt(n), keep going will only overlap
class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        mark = {i:True for i in xrange(n)}
        primes = 0
        for num in xrange(2, n):
            if not mark[num]: continue
            primes += 1
            mul = num*num
            while mul*mul < n:
                mark[mul] = False
                mul += num
        return primes

s = Solution()
print s.countPrimes(1500000)