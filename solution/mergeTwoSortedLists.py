# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        run = head
        while l1 is not None and l2 is not None:
        	if l1.val > l2.val:
        		run.next = l2.val
        		l2 = l2.next
        	else:
        		run.next = l1.val
        		l1 = l1.next
        	run = run.next
        if l1 is None: l1, l2 = l2, l1
        run.next = l1

        return head.next