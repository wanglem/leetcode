class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str (abccba, abcba)
        :rtype: str
        """
        def isPalindrome(s):
        	l = len(s)
        	for i in xrange(0,l):
        		if s[i] != s[l - i - 1]: return False
        	return True

        slidingWindow = len(s)
        while slidingWindow > 0:
        	for i in xrange(0,len(s) - slidingWindow + 1):
        		if isPalindrome(s[i:i+slidingWindow]): return s[i:i+slidingWindow]
        	slidingWindow -= 1

        return
        			
