# 133.
# Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


# OJ's undirected graph serialization:
# Nodes are labeled uniquely.

# We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
# As an example, consider the serialized graph {0,1,2#1,2#2,2}.

# The graph has a total of three nodes, and therefore contains three parts as separated by #.

# First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
# Second node is labeled as 1. Connect node 1 to node 2.
# Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
# Visually, the graph looks like the following:


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
