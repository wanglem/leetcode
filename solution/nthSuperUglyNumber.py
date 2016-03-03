# 313. nth super ugly number, only can be divided by given primes list
# each prime keeps a counter, that points to kth element in ugly array, next biggest for 
# that prime is prime*ugly[counter+1], can use a heap to keep k primes
import heapq
class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        if n == 1: return 1
        hp = []
        for i in xrange(len(primes)):
            heapq.heappush(hp, (primes[i], -1, i))

        nums = []
        while n > 1:
            num, cnt, i = heapq.heappop(hp)
            if not nums or  nums[-1] != num:
                nums.append(num)
                n -= 1
            heapq.heappush(hp, (nums[cnt+1]*primes[i], cnt+1, i))

        return nums[-1]

s = Solution()
print s.nthSuperUglyNumber(8, [2,7,13,19])
