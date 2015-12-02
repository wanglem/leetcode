class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        phoneLetter = {
            '1': [], '2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'], '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'], '6': ['m', 'n', 'o'], '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'], '9': ['w', 'x', 'y', 'z']
        }
        comb = []
        if len(digits) == 0: return comb
        comb.extend(phoneLetter[digits[0]])
        for d in digits[1:]:
            letter = phoneLetter[d]
            rs = []
            for c in comb:
                for l in letter:
                      rs.append(c+l)
            comb = rs
        return comb

sol = Solution()
print sol.letterCombinations("23")
