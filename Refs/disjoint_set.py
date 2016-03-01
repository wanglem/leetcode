# [1, 2, 3, 4, 5] five person
# [1,2],[4,5], [5,1] are friends pairs
# find all "frield groups"

# disjoint_set

# Linked List implementation
# 1. create five disjoint set, representative is itself, points to None. 
# Each creation is O(1) Operation, O(n) total
# 1 -> None, 2 -> None, 3 -> None, 4 -> None, 5 -> None,
# |          |          |          |          |
# 1          2          3          4          5

# 2. merge all disjoint set based on friends group
# repoint to largest new representative
# 2 -> 1 -> None, 3 -> None, 5 -> 4 -> None,
# |    |          |          |    |
# 2    2          3          5    5
# Then:
# 3 -> None, 5 -> 4 -> 2 -> 1 -> None,
# |          |    |    |    |
# 3          5    5    5    5
# Done

# each representative contains a friends group.


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