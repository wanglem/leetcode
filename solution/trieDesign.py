# 208. design a trie
# make sure insert a existing prefix of a word will mark that word complete also
class TrieNode(object):
    def __init__(self, char):
        """
        Initialize your data structure here.
        """
        # CB shows as:
        # CNode -> {'b' -> BNode}
        self.char = char
        self.neighbors = {}
        self.complete = False

    def hasChild(self, char):
        return char in self.neighbors
    def getChild(self, char):
        if self.hasChild(char):
            return self.neighbors[char]
        return None
    def completeWord(self):
        self.complete = True
    def isComplete(self):
        return self.complete
    def getChar(self):
        return self.char
    def append(self, node):
        self.neighbors[node.getChar()] = node
class Trie(object):

    def __init__(self):
        self.root = TrieNode('#')

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        (i, append) = self._dfsSearch(word)
        self._pushback(append, word[i:])

    def _pushback(self, node, word):
        for c in word:
            newNode = TrieNode(c)
            node.append(newNode)
            node = newNode
        node.completeWord()

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        (i, node) = self._dfsSearch(word)
        return i == len(word) and node.isComplete()

    def _dfsSearch(self, s):
        append = self.root
        i = 0
        while i < len(s) and append.hasChild(s[i]):
            append = append.getChild(s[i])
            i += 1

        return (i, append)

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        (i, _) = self._dfsSearch(prefix)
        return i == len(prefix)   

# Your Trie object will be instantiated and called as such:
trie = Trie()
trie.insert("somestring")
print trie.search("key")
print trie.search('somestring')
print trie.startsWith('somest')