# 42
"""
Left -> Right, i -> j
if Aj >= Ai, calculate and move on
else get highest Aj, calculate and move on

Note: when substract filter Ax to Lower edge
"""
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        height = height[:]
        i = 0
        while i < len(height)-1 :
            if height[i] > height[i+1]:
                height = height[i:]
                break
            i += 1
        j = len(height)-1
        while j > 0:
            if height[j] > height[j-1]:
                height = height[:j+1]
                break
            j -= 1

        i = 0
        total = 0
        while i < len(height)-2:
            j = i+2
            currentHighestIndex = j
            while j < len(height):
                if height[j] > height[currentHighestIndex]:
                    currentHighestIndex = j
                if height[i] <= height[j]:
                    if j == len(height)-1 or (j < len(height)-1 and height[j] > height[j+1]):
                        edge = min(height[i], height[j])
                        total += (j-i-1)*edge - sum(self.waterBase(height[i+1:j], edge))
                        i = j
                        break
                if j == len(height) - 1:
                    edge = min(height[i], height[currentHighestIndex])
                    total += (currentHighestIndex - i - 1)*edge - sum(self.waterBase(height[i+1: currentHighestIndex], edge))
                    i = currentHighestIndex
                    break
                j += 1

        return total

    def waterBase(self, height, edge):
        return [x if x <= edge else edge for x in height]

s = Solution()
t = [5,4,1,2]
# t = [4,2,3]
print s.trap(t)