# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if len(lists) == 0: return []
        if len(lists) == 1:return lists[0]
        if len(lists) == 2: return self.mergeTwoLists(lists[0], lists[1])
        mid = len(lists)/2
        return self.mergeTwoLists(self.mergeKLists(lists[:mid]), self.mergeKLists(lists[mid:]))

    def mergeTwoLists(self, l, r):
        head = ListNode(0)
        run = head
        while l is not None and r is not None:
            if l.val > r.val:
                run.next = r
                r = r.next
            else:
                run.next = l
                l = l.next
            run = run.next
        if l is None: l = r
        run.next = l

        return head.next