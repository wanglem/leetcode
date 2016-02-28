# 282. expression add operation
# DFS approach, directly append path to result for convenience
# edge cases: no 00
# overflow
# pass down an easy caculated stuff, like calcCache
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        start = 0
        for i in xrange(len(num)):
            start = start*10 + ord(num[i]) - ord('0')
            # + op
            self._search(result,num[:i+1],[start],num,i+1, target)
            if start == 0: break

        return result

    def _search(self, result, path, calcCache, num, offset, target):
        if offset == len(num) and sum(calcCache) == target:
            result.append(path)
            return

        start = 0
        for i in xrange(offset, len(num)):
            start = start*10 + ord(num[i]) - ord('0')
            # +
            addOpCache = calcCache+[start]
            self._search(result,path+"+"+str(start),addOpCache,num,i+1, target)
            # - 
            minusOpCache = calcCache+[-1*start]
            self._search(result,path+"-"+str(start),minusOpCache,num,i+1, target)
            # *
            multiplyOpCache = calcCache[:-1]+[calcCache[-1]*start]
            self._search(result,path+"*"+str(start),multiplyOpCache,num,i+1, target)
            if start == 0: break


s = Solution()
print s.addOperators("3456237490",9191)

