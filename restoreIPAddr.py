# 93. restore valid IP address
class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def _restoreIpAddresses(s, offset):
            if offset == 3 and self.isValidSubnet(s, offset):
                return [s]

            rst = []
            for i in xrange(1, len(s)):
                subnet = s[:i]
                if self.isValidSubnet(subnet, offset):
                    found = _restoreIpAddresses(s[i:], offset+1)
                    for j in xrange(len(found)):
                        rst.append(subnet + "." + found[j])

            return rst
                    
        if len(s) < 4 or len(s) > 12: return []
        return _restoreIpAddresses(s, 0)

    def isValidSubnet(self, sub, offset):
        if len(sub) > 3: return False
        if len(sub) == 0: return False
        if sub[0] == '0' and len(sub) != 1: return False
        if int(sub) > 255: return False

        return True

s = Solution()
print s.restoreIpAddresses("25525511135")