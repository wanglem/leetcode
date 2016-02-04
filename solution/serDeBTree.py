# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        tupleSeq = self._treeToTupleSeq(root)
        return self._tupleSeqToBString(tupleSeq)

    def _treeToTupleSeq(self, root):
        if root is None: return []
        bfsLayer = [(0, root)]
        tSeq = []

        while len(bfsLayer) > 0:
            nextBfs = []
            for tup in bfsLayer:
                index, node = tup[0], tup[1]
                tSeq.append((index, node.val))
                if node.left is not None:
                    nextBfs.append((2*index+1, node.left))
                if node.right is not None:
                    nextBfs.append((2*index+2, node.right))
            bfsLayer = nextBfs

        return tSeq


    def _tupleSeqToBString(self, tseq):
        data = [str(tup[0])+"@"+tup[1] for tup in tseq]
        return "#".join(data)

    def _bStringToTupeSeq(self, bstr):
        tseq = []
        for nodehash in bstr.split("#"):
            tup = nodehash.split("@")
            tseq.append((int(tup[0]), tup[1]))

        return tseq

    def _tupleSeqToTree(self, tseq):
        root = TreeNode(tseq[0][1])
        bfsLayer = [(0, root)]
        i = 1
        while len(bfsLayer) > 0:
            nextBfs = []
            for tup in bfsLayer:
                while i < len(tseq):
                    if tseq[i][0] == 2*tup[0]+1:
                        tup[1].left = TreeNode(tseq[i][1])
                        nextBfs.append((2*tup[0]+1, tup[1].left))
                        i += 1
                    elif tseq[i][0] == 2*tup[0]+2:
                        tup[1].right = TreeNode(tseq[i][1])
                        nextBfs.append((2*tup[0]+2, tup[1].right))
                        i += 1
                    else:
                        break
            bfsLayer = nextBfs

        return root

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        if data == "": return None
        tupleSeq = self._bStringToTupeSeq(data)
        return self._tupleSeqToTree(tupleSeq)

a = TreeNode('a')
b = TreeNode('b')
c = TreeNode('c')
d = TreeNode('d')
e = TreeNode('e')
f = TreeNode('f')
g = TreeNode('g')
h = TreeNode('h')
i = TreeNode('i')

f.left = b
f.right = g
b.left = a
b.right = d
d.left = c
d.right = e
g.right = i
i.left = h

s = Codec()
print s.serialize(f)
print s.serialize(s.deserialize("0@f#1@b#2@g#3@a#4@d#6@i#9@c#10@e#13@h"))