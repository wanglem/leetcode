# 143.
# Definition for singly-linked list.
# solution:
# 1. find middle point
# 2. push latter part to a stack
# 3. pop stack and insert each to former part
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head is not None: return head
        stack = []
        newEnd, fast = head, head
        latterPart = head
        while True:
        	if fast.next is None:
        		latterPart = newEnd.next
        		newEnd.next = None
        		break
        	if fast.next.next is None:
        		latterPart = newEnd.next.next
        		newEnd.next.next = None
        		break
        	newEnd = newEnd.next
        	fast = fast.next.next
        while latterPart:
        	stack.append(latterPart)
        	latterPart = latterPart.next

        p = head
        while p:
        	middle = stack.pop()
        	middle.next = p.next
        	p.next = middle
        	p = middle.next

        return head

a = ListNode(0)
b = a
for i in xrange(1,10):
	b.next = ListNode(i)
	b = b.next
s = Solution()
p = s.reorderList(a)
while p:
	print p.val