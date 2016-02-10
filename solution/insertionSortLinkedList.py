# 147. Insert sort on a linked list
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# for each node, insert to sorted list.
# an optimization: keep appending new value if it's higher than sorted highest value
class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head: return None
        pre, cur = head, head.next
        fakeHead = ListNode(0)
        fakeHead.next = head
        fakeHead.next.next = None
        while cur:
            insertNode = cur
            cur = cur.next
            insertNode.next = None
            if insertNode.val >= pre.val:
                pre.next = insertNode
                pre = pre.next
            else:
                new = fakeHead
                while new.next and new.next.val < insertNode.val:
                    new = new.next
                insertNode.next = new.next
                new.next = insertNode

        return fakeHead.next
