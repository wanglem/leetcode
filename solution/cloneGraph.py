# 133.
# Definition for a undirected graph node
# class UndirectedGraphNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: UndirectedGraphNode
        :rtype: UndirectedGraphNode
        """
        
        if node is None: return None
        cloned = {node.label: []} # label -> List[label] (from -> neighbors)
        nodes = {node.label: UndirectedGraphNode(node.label)} # label -> node
        # from label -> to label
        queue = [(node.label, m) for m in node.neighbors]
        while queue:
            f, t = queue.pop()
            if f not in cloned:
                cloned[f] = []
                nodes[f] = UndirectedGraphNode(f)
            if t.label not in cloned[f]:
                cloned[f].append(t.label)
                nodes[f].neighbors = nodes[f].neighbors.append(UndirectedGraphNode(t.label))
                queue.extend([(t.label, m) for m in t.neighbors])

        return nodes[node.label]
