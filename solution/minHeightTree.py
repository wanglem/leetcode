# 310. minimum height tree in a undirected graph
class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1: return []
        graph = [{} for _ in xrange(n)]
        for edge in edges:
            l, r = edge[0], edge[1]
            graph[l][r] = r
            graph[r][l] = l

        leaves = [i for i in xrange(n) if len(graph[i]) == 1]
        while n >= 2: # either 1 node left or 2 nodes left, all leaves are removed!
            newLeaves = []
            for leaf in leaves:
                parent = graph[leaf].values()[0]
                if len(graph[parent]) == 2:
                    newLeaves.append(parent)
                del graph[parent][leaf]
                n -= 1
            leaves = newLeaves
        return list(leaves)

s = Solution()
print s.findMinHeightTrees(4,  [[1, 0], [1, 2], [1, 3]])