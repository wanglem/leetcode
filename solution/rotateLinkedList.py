# 61.
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if k == 0: return head
        n = 0
        r = head
        while r is not None:
            n += 1
            r = r.next
        if n == 0: return head
        k = k % n

        # 1 - 2 - 3 - 4 - 5 - None
        newEnd = runner = head
        while runner.next is not None:
            if k > 0: k -= 1
            else: newEnd = newEnd.next
            runner = runner.next
        runner.next = head
        newStart = newEnd.next
        newEnd.next = None

        return newStart