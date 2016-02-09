a = set([1,2,3])

b = set([3,4])

a.union(b) # return new union, not modify a or b
a.update(b) # return None, modify a 

a.intersection(b) # return new intersection
a.intersection_update(b)  # modify a with intersection

a.difference_update(b) # modify a, with diff