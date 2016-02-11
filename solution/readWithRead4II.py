# 158.
# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):

# similar with call-once read, 
# but need an additional buffer holds 4 len buffer to avoid offset error.
class Solution(object):
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        