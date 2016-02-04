# 96. 
# Given n, how many structurally unique BST's (binary search trees) 
# that store values 1...n?
# For example,
# Given n = 3, there are a total of 5 unique BST's.

# Solution:
# BTrees are symmetrical, so select k (1~n) as root, all i < k should go left branch
# and all j > k should go right branch. Now we have a recursive formula