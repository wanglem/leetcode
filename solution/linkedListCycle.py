# 141. detect if cycle exists in linkedlist
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        l, r = head, head
        while l and r and r.next:
            l = l.next
            r = r.next.next
            if l == r: return True

        return False