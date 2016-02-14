a = "  ccdd  "
print a.strip() # strip leading/trailing white space

a = ["a", "b", "c"]
# reverse a list
a.reverse() 
# partial reverse a list, slice with index and it works
# reversed only will return an object
a[1:2] = reversed(a[1:2])
# print "a,b,c", concat all element in a list
print ",".join(a)
