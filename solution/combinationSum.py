# 39
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        return self._combSum(candidates, target)

    def _combSum(self, candidates, target):
        if not candidates: return []
        if candidates[0] > target: return []

        current = candidates[0]
        dv = target/current
        result = []
        layer = [current] * dv
        while dv >= 0:
            part = []
            # print dv, target, layer, result
            if current*dv == target:
                result += [layer]
            else:
                part = self.combinationSum(candidates[1:], target - current * dv)
                if part: result += [layer + p for p in part]
            dv -= 1
            layer = [current]*dv

        return result

s = Solution()
print s.combinationSum([1], 1)

