# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        runner = ListNode(0)
        fakeHeader = runner
        buf = []
        while head is not None:
            buf.append(head)
            head = head.next
            buf[-1].next = None # clear old link
            if len(buf) == 2:
                runner.next = buf[1]
                runner.next.next = buf[0]
                buf = []
                runner = runner.next.next
        if buf: runner.next = buf[0]

        return fakeHeader.next

a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
a.next = b
b.next = c
sol = Solution()
print sol.swapPairs(a)