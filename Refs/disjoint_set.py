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