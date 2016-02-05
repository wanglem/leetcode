import heapq

l = [7,9,5]

heapq.heapify(l)

while l:
	# min heap
	# prints 5, 7, 9
	print heapq.heappop(l) 

a = []
heapq.heappush(a, 4)
heapq.heappush(a, 9)
heapq.heappush(a, 1)

while a:
	# min heap
	# prints 1, 4, 9
	print heapq.heappop(a)