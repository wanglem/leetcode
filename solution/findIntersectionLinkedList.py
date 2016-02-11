# 160. find the intersection two linked list, null if none
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# This is Easy question, I think it's a merge sort variation and both lists are sorted
# Otherwise we'll just need have a hashtable recording one linked-list
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        l, r = headA, headB
        while l and r:
            if l.val > r.val:
                r = r.next
            elif l.val < r.val:
                l = l.next
            else:
                if l == r: return l
                l = l.next
                r = r.next

        return None