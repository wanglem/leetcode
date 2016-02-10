# 146. LRU
# my solution is to use a dict with value and ts, but set will take O(n) time
# 
# A Good solution is:
# use a double linked-list keep using order (no ts needed), and a dict stores 
# all nodes. Double linked-list can make sure O(1) on insert and delete. something like:
# node.pre.next = node.next # delete current node
# node.next = head, head = node # head is most recently used
import time
class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.vol = 0
        self.cap = capacity
        # [key:(value, last_seen_ts), ....]
        self.cache = {}

    def get(self, key):
        """
        :rtype: int
        """
        if key not in self.cache: return -1

        (v, _) = self.cache[key]
        self.cache[key] = (v, time.time())
        return v

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key in self.cache:
            self.cache[key] = (value, time.time())
        else:
            if self._isCapped():
                self._removeLeastUsed()
                self.vol -= 1
            self.cache[key] = (value, time.time())
            self.vol += 1
    
    def _isCapped(self):
        return self.vol >= self.cap

    def _removeLeastUsed(self):
        keyToRemove = None
        oldest = None
        for k in self.cache:
            if not keyToRemove:
                keyToRemove = k
                oldest = self.cache[k][1]
            elif oldest > self.cache[k][1]:
                oldest = self.cache[k][1]
                keyToRemove = k

        del self.cache[keyToRemove]

s = LRUCache(1)

s.set(1,2)
print s.get(1)

s.set(2,3)
print s.get(1)