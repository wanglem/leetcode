# 40
class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        return self._combSumNoDup(candidates, target)


    def _combSumNoDup(self, candidates, target):
        if not candidates: return []
        if target < 0 or candidates[0] > target: return []
        result = []
        for i in xrange(len(candidates)):
            if i > 0 and candidates[i-1] == candidates[i]: continue
            if candidates[i] == target: 
                result += [[candidates[i]]]
                break
            elif candidates[i] < target:
                part = self._combSumNoDup(candidates[i+1:], target - candidates[i])
                if part: result += [[candidates[i]] + p for p in part]

        return result

s = Solution()
l = [10,1,2,7,6,1,5]
print s.combinationSum2(l, 8)