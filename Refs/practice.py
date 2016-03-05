def qs(L):
	# quick sort
	if len(L) < 2: return L
	pivot = L[-1]
	return qs([x for x in L[:-1] if x < pivot]) + [L[-1]] + qs([x for x in L[:-1] if x >= pivot])

def qs2(L, lo, hi):
	# quick sort, with inplace swap
	if lo >= hi: return
	def partition(pt, lo, hi):
		def swap(pt, i, j):
			if i != j: pt[i], pt[j] = pt[j], pt[i]
		pivot = pt[hi]
		lo2 = lo
		for pi in xrange(lo, hi):
			if pt[pi] < pivot:
				swap(pt, lo2, pi)
				lo2 += 1

		pt[lo2], pt[hi] = pivot, pt[lo2]
		return lo2

	if len(L) < 2: return L
	pivotIndex = partition(L, lo, hi)
	qs2(L, lo, pivotIndex-1)
	qs2(L, pivotIndex+1, hi)

def bsearch(nums, target):
	lo, hi = 0, len(nums)
	while lo < hi:
		mid = (hi-lo)/2+lo
		if target == nums[mid]: return True
		if target > nums[mid]: lo = mid+1
		else: hi = mid
	return False


def unionFind(n, edges):
	def find(x):
		if x != parent[x]:
			# find parent, and assign parent's parent to current
			# so next run can go directly to parent!
			parent[x] = find(parent[x])
		return parent[x]

	def union(edge):
		p1, p2 = map(find, edge)
		# rank[i] shows number of child node i has
		# used for balance the graph path
		if rank[p1] <= rank[p2]:
			parent[p2] = p1
			rank[p1] = rank[p2]+1
		else:
			parent[p1] = p2
			rank[p2] = rank[p1]+1

	parent = range(n)
	rank = [0]*n
	map(union, edges)
	return len({find(x) for x in xrange(n)})

e = [[0, 1], [1, 2], [3, 4]]
print unionFind(5, e)



