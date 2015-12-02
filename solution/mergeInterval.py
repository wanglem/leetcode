a = [1,2,3,5,7,8,10]
b = [1,2,2,2,3,4,5]

def merge(l):
	if len(l) < 2: return l

	i = l[0]
	result = []
	for x in xrange(1, len(l)):
		if l[x] != l[x-1] + 1 and l[x] != l[x-1]:
			result.append((i, l[x-1]))
			i = l[x]
	result.append((i, l[-1]))

	return result

print merge(b)