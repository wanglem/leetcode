# Status: Time Exceeded.
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int] [1,3,5,7,9]
        :type nums2: List[int] [2,4,6,8]
        :rtype: float
        """
        def findKthElement(l, r, k):
            print l, r, k
            if len(l) > len(r):     l, r = r, l
            if len(l) == 0:         return r[k-1]*1.0
            if k == 1:              return min(l[0], r[0])*1.0

            k1 = (len(l)-1)/2
            k2 = k-k1-2
            if l[k1] == r[k2]:  return l[k1]
            elif l[k1] > r[k2]: return findKthElement(l[:k1+1], r[k2+1:], k-k2-1)
            else: return findKthElement(l[k1+1:], r[:k2+1], k-k1-1)

        l1, l2 = len(nums1), len(nums2)
        if l1 == l2 == 0:
            return None
        elif (l1+l2)%2 == 1:
            return findKthElement(nums1, nums2, (l1+l2)/2+1)
        else:
            return ( findKthElement(nums1, nums2, (l1+l2)/2+1) + 
                     findKthElement(nums1, nums2, (l1+l2)/2  )  )/2

sol = Solution()
l = []
r = [2]
print sol.findMedianSortedArrays(l,r)