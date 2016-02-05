# 128.
# solution: 
# build a hashmap, key is index, sequence length
# One technique worth remembering is, when jump and merge range, 
# no need try cover both lower and higher side, just SKIP if there's lower side, 
# once reach the lowest value of sub-range it should cover all elements in that range!!!

class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic = {e: 1 for e in nums}
        print dic
        for e in nums:
            jump = e
            if jump-1 in dic: continue
            while e in dic and jump+1 in dic:
                dic[e] = dic[e]+dic[jump+1]
                del dic[jump+1]
                jump = jump+1

        return max(dic.values())

s = Solution()
t= [100, 4, 200, 1, 3, 2]
print s.longestConsecutive(t)
