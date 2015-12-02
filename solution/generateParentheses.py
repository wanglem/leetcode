class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def generate(p, n, m):
            if n == 0 and m == 0: return [p]
            i, j = [], []
            if n > 0: i = generate(p+"(", n-1, m)
            if m > 0 and m > n: j = generate(p+")", n, m-1)
            return i + j

        return generate("", n , n)

sol = Solution()
print sol.generateParenthesis(2)