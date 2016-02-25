# 269. allien dictionary. sorted strings, find sorted chars, can be 0 or more correct answers
# 1. get all pairs
# 2. remove invalid pairs, forms a cycle, existing path
# 3. merge pairs to path
# 4. sort path (Topological sort)
class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        if len(words) < 1: return ""
        # char : List[Char]
        lut = {}
        for frm, to in self.nextPair(words):
            state = self.checkState(frm, to, lut, set())
            if state == -1: return ""
            if state == 0: lut[frm] = lut.get(frm, []) + [to]
        
        return self.sortPath(self.buildPaths(lut))


    def sortPath(self, paths):
        order = []
        visited = set()
        for start in paths:
            for char in paths[start]:
                if char in visited: break
                visited.add(char)
                order.append(char)

        return order
    def buildPaths(self, lut):
        visited = set()
        paths = {} # start: path
        for char in lut:
            if char in visited: continue
            paths[char] = []
            path = []
            stack = [char]
            while stack:
                c = stack.pop()
                if c in visited:
                    if c in paths:
                        path.extend(paths[c])
                        del paths[c]
                        break
                path.append(c)
                visited.add(c)
                if c in lut: stack.extend(lut[c])
            paths[char].extend(path)

        return paths

    def nextPair(self, words):
        for i in xrange(len(words)-1):
            for j in xrange(min(len(words[i]), len(words[i+1]))):
                if words[i][j] != words[i+1][j]:
                    yield (words[i][j], words[i+1][j])
                    break
                

    def checkState(self, f, t, lut, visited):
        # if path exists, return 1
        # if a cycle is found, return -1
        # else return 0
        if f in visited: return -1
        visited.add(f)
        if f not in lut: return 0
        if t in lut[f]: return 1
        for nextf in lut[f]:
            return self.checkState(nextf, t, lut, visited)
        return 0

s = Solution()
w = ["wrt", "wrf", "er", "ett", "rftt"]
print s.alienOrder(w)