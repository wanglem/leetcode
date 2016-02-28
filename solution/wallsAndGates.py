# 286. walls and gates
# you can either:
# 1. for each empty room, BFS up, down, left, right search closet gate
# 2. for each gate, BFS up, down, left, right update each empty room
# 	 can terminate when updated value is less than existing value
class Solution(object):
    def wallsAndGates(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        