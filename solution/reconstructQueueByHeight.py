class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        def insert(one, queue):
            infront = one[1]
            queue = queue[:infront] + [one] + queue[infront:]
            return queue
        # sort this with a secondary key
        # process the tallest group first, so we know their order is fixed
        # insert the next tallest group to the already ordered queue, insert the 
        #   most front people first directly to the index (sorted by the secondary key)
        #   because we know other people with same height is after this guy
        heightOrdered = sorted(people, key=lambda x: (-x[0], x[1]))
        ordered = []
        for p in heightOrdered:
            ordered = insert(p, ordered)
        
        return ordered
    
    def conciseVersion(self, people):
        heightOrdered = sorted(people, key=lambda x: (-x[0], x[1]))
        ordered = []
        for p in heightOrdered:
            ordered = ordered[:p[1]] + [p] + ordered[p[1]:]
        
        return ordered


