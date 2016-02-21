# 255. verify an array is preorder BST
# divide and conquer.
# get first element e, divide rest into two parts, p1, p2
# e > p1 and e < p2 
# resursive above step with p1 and p2
class Solution(object):
    def verifyPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: bool
        """
        