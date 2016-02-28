# 284. peak iterator
class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.iter = iterator
        self.peeked = None
        if self.iter.hasNext():
            self.peeked = self.iter.next()
        
    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        return self.peeked

    def next(self):
        """
        :rtype: int
        """
        if not self.hasNext(): return None
        result = self.peeked
        self.peeked = None
        if self.iter.hasNext():
            self.peeked = self.iter.next()
        return result

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.peeked is not None