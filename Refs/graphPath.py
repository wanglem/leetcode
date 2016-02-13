import math
import heapq
n = 10
graph = [[0 for _ in range(n)] for _ in range(n)]
visited = [[False for _ in graph[0]] for _ in graph]
start, end = (0,0), (n-1, n-1)
visited[start[0]][start[1]] = True

def findPath():
	path = [(None, start)]
	nodeStack = [start]
	while nodeStack:
		next = nodeStack.pop()
		if next = end: break
		visited[next[0]][next[1]] = True
		d = distance(next, end)
		nbors = getNeighbors(next[0], next[1])
		# closest at the end
		weightednbors = sorted(nbors, key=lambda x: -1*distance(x, end))
		nodeStack.extend(weightednbors)
		path.extend([(next, n) for n in weightednbors])
	return path

print constructPath(path)

def constructPath(path):
	pass

def getNeighbors(i, j):
	# return not visited neighbors
	pass
def distance(start, end):
	x, y = abs(end[0]-start[0]), abs(end[1]-start[1])
	return math.sqrt(x*x+y*y)

