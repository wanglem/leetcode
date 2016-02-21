# 249. grouping shifted strings
# attention to round to next cycle, az -> ba -> ... -> yx
class Solution(object):
    def groupStrings(self, strings):
        """
        :type strings: List[str]
        :rtype: List[List[str]]
        """
        def cal(l1, l2):
            off = ord(l1) - ord(l2)
            if off < 0: off += 26
            return off
        groups = {}
        for s in strings:
            offset = ""
            for i in xrange(1, len(s)):
                offset += str(cal(s[i], s[i-1]))
            if len(s) == 1: offset = "#"
            groups[offset] = groups.get(offset, []) + [s]

        rst = []
        for off in groups:
            rst.append(sorted(groups[off]))

        return rst

s = Solution()
print s.groupStrings(["ab", "ba"])