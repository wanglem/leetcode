# 71.
class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        dirs = path.split('/')
        reducedDirs = []
        for d in dirs:
            if d == '.' or d == '':
                continue
            elif d == '..':
                if reducedDirs: reducedDirs.pop()
            else:
                reducedDirs.append(d)

        return "/" + "/".join(reducedDirs)


a = "/a/../../"
s = Solution()
print s.simplifyPath(a)