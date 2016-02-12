# 167. sorted array, find two sum
# for each i in array, bsearch nums[i:]
class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """

        for i in xrange(len(numbers)-1):
            j = self.bsearch(numbers, i+1, len(numbers)-1, target - numbers[i])
            if j != -1: return [i+1, j+1]
        return [-1, -1]

    def bsearch(self, num, l, r, target):
        while l < r:
            mid = (r-l)/2+l
            if num[mid] == target: return mid
            if num[mid] < target: l = mid+1
            else: r = mid
        if num[l] == target: return l
        return -1

s = Solution()
n = [3,24,50,79,88,150,345]

print s.twoSum(n, 200)