# 170. two sum data structure
# solution: hash table contains all elements
class TwoSum(object):

    def __init__(self):
        """
        initialize your data structure here
        """
        self.hashset = dict()
        # self.unique = []

    def add(self, number):
        """
        Add the number to an internal data structure.
        :rtype: nothing
        """
        if number in self.hashset:
            self.hashset[number] = 2
        else:
            self.hashset[number] = 1
            self.unique.append(number)

    def find(self, value):
        """
        Find if there exists any pair of numbers which sum is equal to the value.
        :type value: int
        :rtype: bool
        """
        u = self.unique
        for k in u:
            t = value - table[k]
            if t in table:
                if t == k and table[t] == 1: continue
                return True

        return False
        