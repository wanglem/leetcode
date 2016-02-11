# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):

# I guess the question doesn't really make sense with python, but more about pointer
class Solution(object):
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        count = n/4
        if n%4 != 0: count += 1
        m = 0
        for i in xrange(count):
            m += read4(buf[i*4:])
        
        return min(m, n)