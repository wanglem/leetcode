class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        slen = len(s)
        if slen < 2:  return slen
        l, r, curLen, longest = 0, 1, 1, 1
        window = {s[0]: True}
        while r < slen:
        	while s[r] in window:
        		del window[s[l]]
        		l += 1
        		curLen -= 1
        	window[s[r]] = True
        	curLen += 1
        	longest = longest if longest > curLen else curLen
        	r += 1

        return longest



t = "cavb"
sol = Solution()
print sol.lengthOfLongestSubstring(t)