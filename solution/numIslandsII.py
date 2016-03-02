# 305. num islands II, given a list of coordinates on 2d array, return number of independent
# groups after each position is added
# disjoint_set, Union Find
# two ways of union find here:
# 1. dedicated leader of each group, leader will keep a counter of number of nodes it has, and all
#    others point to leader when a new position is added, add it to the largest group, and update 
#    other adjacnet groups to the largest group
# pro: find leader quickly, check if two nodes in same group in O(1)
# con: add node op can be expensive because require update each node to point to new leader
# 
# 2. each node only point to its parent, (leader points to itself). If a position added, it becomes 
#    a new leader. For each neighbor, find the leader of that group and point it to this new leader,
#    also update new leader's group count.
# pro: add node operation is cheaper
# con: find leader is slower, check two nodes same group is slower

class Solution(object):
    def numIslands2(self, m, n, positions):
        """
        :type m: int
        :type n: int
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        counts = []
        island = Island(m, n)
        for pos in positions:
            island.add(pos[0], pos[1])
            counts.append(island.numIslands())
        return counts

class Island(object):

    def __init__(self, m, n):
        self.index = [-1]*(m*n)
        self.n = n
        self.m = m
        self.count = 0

    def add(self, row, col):
        nid = self.getId(row, col)
        self.index[nid] = nid
        self.count += 1
        for direction in [(1,0), (-1,0), (0,1), (0,-1)]:
            neighbor = self.getId(row+direction[0], col+direction[1])
            if neighbor >= 0 and neighbor < len(self.index) and self.index[neighbor] != -1:
                # smarter leader election?? append pos to smallest neighbor group
                self.merge(neighbor, nid)

    def getId(self, i, j):
        if not (0<=i<self.m and 0<=j<self.n):
            return -1
        return i*self.n+j

    def merge(self, id1, id2):
        leader1, leader2 = self.getLeader(id1), self.getLeader(id2)
        if leader1 != leader2:
            self.index[leader2] = leader1
            self.count -= 1

    def getLeader(self, nid):
        while self.index[nid] != nid:
            nid = self.index[nid]
        return nid

    def numIslands(self):
        return self.count


s = Solution()
011
101
010
(0,1),(1,2)
pos = [[0,1],[1,2],[2,1],[1,0],[0,2]]
print s.numIslands2(3,3,pos)





