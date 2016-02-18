# 218. given lIndex, rIndex, height of a build, sorted by lIndex, draw the contour
# below code takes O(n2) time, which is just a simple approach, not ideal.
# better solution is divide and conquor, very similar as merge sort.
# basically divide buildings into two groups and recursive, return skyline to stop (1/2 building),
# merge two skylines is like merge sort.
# more at: http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        print buildings
        b = buildings
        buf = []
        i = 1
        segStart = 0
        contour = []
        while i < len(b) - 1:
            l, r, h = b[i][0], b[i][1], b[i][2]
            if r >= b[i+1][0]:
                i += 1
                continue
            contour.extend(self.drawOutline(b[segStart:i+1]))
            i, segStart = i+2, i+1

        if segStart < len(b):
            contour.extend(self.drawOutline(b[segStart:]))
        return contour

    def drawOutline(self, buildings):
        outline = [buildings[0]]
        preIndex = 0
        for b in buildings[1:]:
            (preIndex, outline) = self.insertRanges(outline, preIndex, b[:])
            print preIndex, outline        
        return self.processContour(outline)

    def insertRanges(self, bs, i, rg):
        # i position is previous building left index
        start = i
        merged = []
        offset = start + 1
        if bs[start][0] == rg[0]: offset = start
        while rg and i < len(bs):
            pre = bs[i]
            if rg[0] == rg[1]: break
            if rg[0] == pre[1]:
                merged.extend([pre, rg])
                break
            seg = [rg[0], min(rg[1], pre[1]), rg[2]]
            rg[0] = seg[1]
            if seg[0] != pre[0]:
                merged.append([pre[0], seg[0], pre[2]])
            merged.append([seg[0], min(pre[1], seg[1]), max(pre[2], seg[2])])
            if seg[1] != pre[1]:
                h = pre[2] if pre[1]>seg[1] else seg[2]
                merged.append([min(pre[1], seg[1]), max(pre[1], seg[1]), h])
            i += 1
        if rg[0] != rg[1]: merged.append(rg)
        return (offset, bs[:start] + merged + bs[i:])

    def processContour(self, o):
        contour = []
        buf = o[0]
        for i in xrange(1, len(o)):
            if buf[2] == o[i][2]:
                buf[1] = o[i][1]
            else:
                contour.append([buf[0], buf[2]])
                buf = o[i]
        contour.append([buf[0], buf[2]])
        contour.append([buf[1], 0])
        return contour

s = Solution()
# sky = [ [2,9,10], [3,7,15], [5,12,12], [15,20,10], [19,24,8], [24, 30, 9]]
sky = [[15,20,10], [19,24,8], [24, 30, 9]]
# [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
print s.getSkyline(sky)