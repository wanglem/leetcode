# 47.
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return self._hashSetSolution(nums)

    def _recursiveSolution(self, nums):
        pass

    def _hashSetSolution(self, nums):
        track = {"".join(map(str, nums)): nums}
        for i in xrange(len(nums)-1):
            for val in track.values():
                for k in xrange(i+1, len(nums)):
                    if val[i] == val[k]: continue
                    tmp = val[:]
                    tmp[i], tmp[k] = tmp[k], tmp[i]
                    hashKey = "".join(map(str, tmp))
                    if hashKey not in track:
                        track[hashKey] = tmp
        return track.values()


s = Solution()
print s.permuteUnique([1,1,1,1])