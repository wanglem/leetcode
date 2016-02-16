# 210. course schedule
# build a graph and do topological sort
# topological sort is for unidirectional graph, it only shows order of a path.
# TOPOLOGICAL SORT: 
# DFS on each path, return node bottom up and get sorted graph nodes
class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        ends = [True for _ in xrange(numCourses)]
        pre = [[] for _ in xrange(numCourses)]
        for c, prec in prerequisites:
            pre[prec].append(c)
            ends[c] = False
        seen = set()
        order = []
        for startCourse in xrange(numCourses):
            if not ends[startCourse]: continue
            # startCourse has no prerequisites
            order.extend(self.dfs(startCourse, pre, seen))
        return order[::-1]

    def dfs(self, course, pre, seen):
        # course passed in should have no prerequisites
        if course in seen: return []
        seen.add(course)
        if not pre[course]: return [course]
        order = []
        for courseToTake in pre[course]:
            order.extend(self.dfs(courseToTake, pre, seen))
        order.append(course)
        return order


s = Solution()
p = [[3, 1], [3,2], [1,0],[2,0]]
print s.findOrder(4, p)