# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        def _addThem(l, r, carry):
            if l is None and r is None:
                if carry == 0:  return None
                else:           return ListNode(carry)

            if l is None: l, r = r, l

            if r is None:
                # l cannot be None in this case
                addedVal = l.val + carry
                node = ListNode(addedVal%10)
                node.next = _addThem(l.next, None, addedVal/10)
                return node
            else:
                addedVal = l.val + r.val + carry
                node = ListNode(addedVal%10)
                node.next = _addThem(l.next, r.next, addedVal/10)
                return node

        return _addThem(l1, l2, 0)
