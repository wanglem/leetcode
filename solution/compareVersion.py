# 165. compare two version, like application version
# just to handle different cases
class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        i = 0
        result = 0
        while i < len(version1) and i < len(version2):
            if version1[i] != version2[i]:
                if version1[i] == '.': return -1
                if version2[i] == '.': return 1
                if int(version1[i])-int(version2[i]) > 0:
                    return 1
                return -1
            i += 1

        if i == len(version1): return 0
        if i  < len(version1): return 1
        return -1