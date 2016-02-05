from collections import deque

d = deque([1,2,3])
d.append(7)
d.append(5)

while d:
	print d.popleft()