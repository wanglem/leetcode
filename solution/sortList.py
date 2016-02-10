# 148. 
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# const space, O(nlogn). merge sort + recursion
# partition trick: use fakeHead for slow
class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head: return None
        if not head.next: return head
        (left, right) = self._partition(head)
        return self._merge(self.sortList(left), self.sortList(right))

    def _partition(self, head):
        if not head: return (None, None)
        slow, fast = ListNode(0), head
        slow.next = head
        while slow and fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        rightHead = slow.next
        slow.next = None
        return (head, rightHead)



    def _merge(self, l, r):
        fakeHead = ListNode(0)
        f = fakeHead
        while l and r:
            if l.val > r.val:
                f.next = r
                r = r.next
            else:
                f.next = l
                l = l.next
            f = f.next

        if l is None: l = r
        f.next = l
        return fakeHead.next