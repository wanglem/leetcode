# 271. encode and decode list of string
# nothing special, I guess it's more for a protocal design
# can design a "header", contains header length, and each string's length, something like
# intput: [this, is, a, string]
# output: 7^4#2#1#6thisisastring
# numStrings^1st#2nd#3rd#4th#....nth[concat string]
class Codec:

    def encode(self, strs):
        """Encodes a list of strings to a single string.
        
        :type strs: List[str]
        :rtype: str
        """
        header = []
        concat = ""
        for s in strs:
            concat += s
            header.append(str(len(s)))
        return str(len(header))+"^"+"#".join(header) + "#" + concat

    def decode(self, s):
        """Decodes a single string to a list of strings.
        
        :type s: str
        :rtype: List[str]
        """
        i = 0
        totalLen = 0
        while i < len(s) and s[i] != '^':
            totalLen = totalLen*10 + int(s[i])
            i += 1
        header = []
        j = i
        while totalLen > 0:
            i = j = j+1
            while s[j] != '#' and j < len(s):
                j += 1
            header.append(int(s[i:j]))
            totalLen -= 1
        decoded = []
        start = j+1
        for offset in header:
            decoded.append(s[start:start+offset])
            start = start+offset

        return decoded

s = Codec()
t = ["abc", "dec", "", ""]
print s.decode(s.encode(t))

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))