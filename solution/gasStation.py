# 134.
# Solution::
# the trick is is i can not reach to i+k, 
# then anyone between i to i+k cannot reach to i+k either
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        i = 0
        while i < len(gas):
            gasLeft = 0
            for j in xrange(i, len(gas)+i+1):
                k = j%len(gas)
                gasLeft += gas[k] - cost[k]
                if gasLeft < 0: break
            if j == len(gas)+i and gasLeft >= 0: return i
            i = j + 1

        return -1


s = Solution()
print s.canCompleteCircuit([1,2], [2,1])