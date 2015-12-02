# 15337->True 15437->True 15347->False 12345->True

a = [1,5,3,3,7]
b = [1,5,4,3,7]
c = [1,5,3,4,7]
d = [1,2,3,4,7]

def getSmallestIndex(l):
	s = 0
	for i in xrange(1, len(l)):
		if l[s] >= l[i]: s = i

	return s

def swap(l, i, j):
	l[i], l[j] = l[j], l[i]
	return l

def isNonDecreasing(l):
	for i in xrange(0, len(l)-1):
		if l[i] > l[+1]: return False
	return True

def swapAndNoneDecreasing(l):
	for i in xrange(0,len(l) - 1):
		if l[i] > l[i+1]: 
			return isNonDecreasing(swap(l, i, getSmallestIndex(l[i+1:])))

	return True

print swapAndNoneDecreasing(a)
print swapAndNoneDecreasing(b)
print swapAndNoneDecreasing(c)
print swapAndNoneDecreasing(d)