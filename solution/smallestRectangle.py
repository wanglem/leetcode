# 302. smallest rectangle area, all 1s are connected (four direction)
# bsearch, e.g. if search up, search half of remaining space for that horizontal line
# if there's 1, keep going half up, else go half down.
# 
# notice that return lo will extend 1 more when reach down and right, because
# if lo found lo will be mid+1
class Solution(object):
    def minArea(self, image, x, y):
        """
        :type image: List[List[str]]
        :type x: int
        :type y: int
        :rtype: int
        """
        if len(image) == 0: return 0
        m, n = len(image), len(image[0])
        upper = self.attemptSearch(image, 0, x, n, True, True)
        lower = self.attemptSearch(image, x, m, n, True, False)
        left  = self.attemptSearch(image, 0, y, m, False, True) # optimization
        right = self.attemptSearch(image, y, n, m, False, False)
        return (lower-upper)*(right-left)

    def attemptSearch(self, image, lo, hi, distance, upORdown, upORleft):
        lower = lo
        while lo < hi:
            mid = (lo+hi)/2
            found = False
            for i in xrange(distance):
                val = image[mid][i] if upORdown else image[i][mid]
                if val == '1':
                    found = True
                    break
            if found:
                if upORleft: hi = mid
                else:        lo = mid+1
            else:
                if upORleft: lo = mid+1
                else:        hi = mid
        return lo

b = [
  "0010",
  "0000",
  "0000"
]
s = Solution()
print s.minArea(b, 0, 2)