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
