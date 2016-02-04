# 97.
# check is s1 and s2 can form a s3
# solution 1: extract s1 from s3 then compare rest, works bu TLE
# solution 2: DFS, recursively search
class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if len(s1) + len(s2) != len(s3): return False
        if len(s1) < len(s2): s1, s2 = s2, s1
        if len(s1) == 0: return True
        for s1pins in self.extract(s1, s3):
            i = pinIndex = 0
            s2Index = 0
            while i < len(s3):
                if pinIndex < len(s1pins) and s1pins[pinIndex] == i:
                    pinIndex += 1
                elif s2Index < len(s2) and s2[s2Index] == s3[i]:
                    s2Index += 1
                else:
                    # not matching
                    break
                i += 1
            if s2Index == len(s2):
                return True

        return False


    def extract(self, s, s3):
        # attempt extract s from s3, 
        pins = [-1]

        while len(pins) > 0:
            prePin = pins.pop() + 1
            if len(s3) - prePin < len(s)-len(pins):
                continue
            while len(pins) < len(s) and s[len(pins)] == s3[prePin]:
                pins.append(prePin)
                prePin += 1
            if len(pins) == len(s):
                yield pins
            else:
                pins.append(prePin)

        yield []


s = Solution()
print s.isInterleave("bcbbacbaabaabbbacbbbcbbb", "babcbbacaabbaaaabacc", "bbcbbbcbabacbcbaacabaabaabaabbbaaacccbbabbbb")


