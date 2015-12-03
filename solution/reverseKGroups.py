# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        runner = ListNode(0)
        fakeHeader = runner
        buf = []
        while head is not None:
            buf.append(head)
            head = head.next
            buf[-1].next = None # clear old link
            if len(buf) == k:
                while buf:
                    runner.next = buf.pop()
                    runner = runner.next

        for i in xrange(0, len(buf)):
            runner.next = buf[i]
            runner = runner.next

        return fakeHeader.next