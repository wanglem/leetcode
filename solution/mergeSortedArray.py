# 88. merge sorted array
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        m, n = m-1, n-1
        while m >= 0 and n >= 0:
            if nums1[m] >= nums2[n]:
                nums1[m+n+1] = nums1[m]
                m -= 1
            else:
                nums[m+n+1] = nums2[n]
                n -= 1

        while n >= 0:
            nums1[n] = nums2[n]
            n -= 1
