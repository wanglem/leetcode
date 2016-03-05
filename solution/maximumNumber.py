# 321. create maximum number from two list, length k, order from each list remains
# divide k into two groups, i and k-i
# for num1 and num2 find i and k-i length biggest array
# the above op can use a stack and greedy approach, not hard at all (see maxINumber())
# then merge the two max array into one

# edge cases:
# if i == j when merging, choose whoever gets higher next value

class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums1: return nums2
        if not nums2: return nums1
        maxNum = []
        for i in xrange(k+1):
            if i > len(nums1) or k-i > len(nums2):
                continue
            max1 = self.maxINumber(nums1, i)
            max2 = self.maxINumber(nums2, k-i)
            maxNum = self.mergeAndCompare(max1, max2, maxNum)

        return maxNum

    def maxINumber(self, nums, k):
        stack = [nums[0]]
        for i in xrange(1, len(nums)):
            while stack and len(stack)+len(nums)-i > k and stack[-1] < nums[i]:
                stack.pop()
            if len(stack) < k:
                stack.append(nums[i])

        return stack

    def mergeAndCompare(self, num1, num2, maxNum):
        print num1, num2, maxNum
        merged = []
        i, j = 0, 0
        while i < len(num1) and j < len(num2):
            m, n = i, j
            while num1[m] == num2[n] and m < len(num1) and n < len(num2):
                m += 1
                n += 1
            if m == len(num1) or n == len(num2):
                merged.extend(num1[i:m])
                merged.extend(num2[j:n])
                i, j = m, n
                break
            if num1[m] > num2[n]:
                merged.append(num1[i])
                i += 1
            else:
                merged.append(num2[j])
                j += 1

        if i == len(num1):
            i, j = j, i
            num1, num2 = num2, num1
        merged.extend(num1[i:])

        if not maxNum: return merged
        for i in xrange(len(merged)):
            if merged[i] > maxNum[i]:
                return merged
            elif merged[i] < maxNum[i]:
                return maxNum
        return merged

n1 = []
n2 = [1]

s = Solution()
print s.maxNumber(n1, n2, 1)
