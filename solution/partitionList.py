# 86.
# I thought this wrong, but nvmd

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        left = ListNode(0)
        right = ListNode(0)
        middle = ListNode(0)
        l, r, m = left, right, middle
        while head:
            if head.val < x:
                l.next = head
                l = l.next
            elif head.val > x:
                r.next = head
                r = r.next
            else:
                m.next = head
                m = m.next
            head = head.next

        l.next = r.next = m.next = None
        fakeHead = ListNode(0)

        if middle.next:
            if left.next:
                fakeHead.next = left.next
                l.next = middle.next
            else:
                fakeHead.next = middle.next
            m.next = right.next
        else:
            if left.next:       fakeHead.next = left.next
            elif right.next:    fakeHead.next = right.next
            l.next = right.next

        return fakeHead.next
            



