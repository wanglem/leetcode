# 288. find if a word's abbreviation is unique
# corner cases need attention:
# two a passed in, but a is still unique
class ValidWordAbbr(object):
    def __init__(self, dictionary):
        """
        initialize your data structure here.
        :type dictionary: List[str]
        """
        self.lut = {}
        for word in dictionary:
            abbr = self._hash(word)
            if self.isUnique(word):
                self.lut[abbr] = word
            else:
                self.lut[abbr] = None
    def isUnique(self, word):
        """
        check if a word is unique.
        :type word: str
        :rtype: bool
        """
        abbr = self._hash(word)
        if abbr in self.lut and (self.lut[abbr] is None or self.lut[abbr] != word):
            return False
        return True
    
    def _hash(self, word):
        if len(word) < 3: return word
        return word[0] + str(len(word)-2) + word[-1]

t = ['dear', 'door', 'cake', 'card']
s = ValidWordAbbr(t)
print s.isUnique("dear")