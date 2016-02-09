# 142.
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# solution:
# 1. two pointer, find the meeting point
# 2. loop once find lengh of cycle
# 3. figure out the rest

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        