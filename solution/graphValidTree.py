# 261. given list of edge, validate if it's a graph tree (no cycle)
# union find and dfs
class Solution(object):
    def validTree(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        if len(edges) < n-1:return False
        edgesOrdered = sorted(edges, key=lambda x: min(x))
        connected = [-1]*n
        for e in edgesOrdered:
            if connected[e[0]] == -1:
                connected[e[0]] = connected[e[1]] = e[0]
            else:
                connected[e[1]] = connected[e[0]]
        if len(set(connected)) > 1: return False
        jump = {}
        for e in edges:
            jump[min(e)] = jump.get(min(e), []) + [max(e)]
        visited = [False]*n
        if not self.isPathUnique(0, jump, visited):
            return False
        return True

    def isPathUnique(self, start, jumps, visited):
        for node in jumps.get(start, []):
            if visited[node]: return False
            visited[node] = True
            isUnique = self.isPathUnique(node, jumps, visited)
            if not isUnique: return False
        
        return True

e = [[1, 0], [2, 0]]
s = Solution()
print s.validTree(3, e)