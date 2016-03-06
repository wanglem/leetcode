# 332. reconstruct itinerary in lexicographical order
# if input is guaranteed valid, then DFS search for each ordered TOs 
# finish: if all visited: return True, if key not in lut return False
class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        lut = {}
        places = len(tickets) + 1
        for f, t in tickets:
            lut[f] = lut.get(f, []) + [t]
        for f in lut:
            lut[f].sort()
        path = ["JFK"]
        self.findPath(lut, path, places)
        return path

    def findPath(self, lut, path, places):
        frm = path[-1]
        if places == 1: return True
        if frm not in lut: return False
        flyTo = lut[frm]
        for i in xrange(len(flyTo)):
            to = flyTo[i]
            lut[frm] = flyTo[:i]+flyTo[i+1:]
            path.append(to)
            if self.findPath(lut, path, places-1):
                return True
            path.pop()
            lut[frm] = flyTo

        return False

s = Solution()
i = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
print s.findItinerary(i)