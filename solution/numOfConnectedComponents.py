# 323. number of connected components in a undirected graph
from collections import deque
class Solution(object):
    def countComponents(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        jump = {}
        for edge in edges:
            node1, node2 = edge[0], edge[1]
            jump[node1] = jump.get(node1, []) + [node2]
            jump[node2] = jump.get(node2, []) + [node1]

        count = 0
        visited = [False] * n
        for i in xrange(n):
            if visited[i]: continue
            count += 1
            queue = deque([i])
            while queue:
                node = queue.popleft()
                if visited[node]: continue
                visited[node] = True
                queue.extend(jump.get(node, []))

        return count


s = Solution()
e = [[0,1],[3,4],[1,2]]
print s.countComponents(5, e)
