# 138.
# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head is None: return None
        visited = []
        random = []
        newHead = RandomListNode(head.label)
        new = newHead
        while head:
            visited.append(head)
            if head.next:
                new.next = RandomListNode(head.next.label)
            if head.random:
                new.random = RandomListNode(head.random.label)
                random.append(head.random)
            head = head.next
            new = new.next

        for rnode in random:
            newlyVisisted = set()
            if rnode in visited: continue

            attempt = RandomListNode(rnode.label)
            while rnode not in visited:
                newlyVisisted.add(rnode)
                attempt.next = rnode.next
                attempt.random = rnode.random
                rnode = rnode.next
                attempt = attempt.next
            attempt.next = visited[0]
            visited = newlyVisisted + visited

        return newHead
