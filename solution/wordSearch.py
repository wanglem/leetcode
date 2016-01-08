# 79.
# basically go through each spot, 
# search left, right, up, down recursively if first matched
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        