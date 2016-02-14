# 187. find repeated DNA sequence, 10 length
# check existence, usually comes down to hashtable or search
# if search would take longer time, and hashtable take more mem
# in this case, there's only 4 chars, hashtable is good solution!
# to improve, need better hash functions!
class Solution(object):
    def findRepeatedDnaSequencesBit(self, s):
        lut = {}
        code = {'A':0, 'C':1, 'G':2, 'T':3}
        result = []
        def getHash(sub):
            k = 0
            for i in xrange(10):
                k |= code[sub[i]] << i*3
            return k
        for i in xrange(len(s) - 10+1):
            sub = s[i:i+10]
            key = getHash(sub)
            if key in lut and lut[key] == 1:
                result.append(s[i:i+10])
                lut[key] = 2
            elif key not in lut: lut[key] = 1
        return result


    def findRepeatedDnaSequencesDecimal(self, s):
        lut = {}
        code = {'A':0, 'C':1, 'G':2, 'T':3}
        result = []
        for i in xrange(len(s) - 10+1):
            key = code[s[i]]
            for j in xrange(1, 10):
                key += key*10 + code[s[i+j]]
            if key in lut and lut[key] == 1:
                result.append(s[i:i+10])
                lut[key] = 2
            elif key not in lut: lut[key] = 1

        return result

    def findRepeatedDnaSequencesSearch(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result = []
        visited = set()
        for i in xrange(len(s)-10+1):
            candidate = s[i:i+10]
            if candidate not in visited and (self.contains(candidate, s[:i]) or self.contains(candidate, s[i+10:])):
                result.append(candidate)
                visited.add(candidate)

        return result

    def contains(self, needle, haystack):
        if len(needle) > len(haystack): return False
        goodchar = set(needle)
        i = 0
        while i < len(haystack)-len(needle)+1:
            j = len(needle)-1
            while j >= 0 and haystack[i+j] == needle[j]:
                j -= 1
            if j < 0: return True
            if haystack[i+j] not in goodchar:
                i = i+j+1
            else:
                i += 1
        return False

dna =  "GCCTCAAGCTATCCTAATTTGCCTGTTCTACTCTGAGTCTCACAAGCTCCCTGGGGGGCCGAACGGACTCGCAGCTTCACGATTAATGAATGTTTCGACAATGAACTTCCTGTGACGAATCTTTGCCGAGCACGGTCTAGCACTATGAGGATTCTCTTCCCGTGTACTCAACGCGGCACATGTTGGAGGTCACCTCGCCGAGCTACCTGTACCCGGGTCTGTAATTCGGATAATTCAGCTAGGGAGCAAATGTGCAGTCAGAGCTTAAGGTACTTCATGTCGCCTTCGCCTGAAGTCCCTTCTTGCACATTATATCCGTTTTGAGGATTCTACTGATAGATAGGGCGCAAACCTCGTTGACGCCCACGACCAAGGATGGTTACTTTTTACAATATGGAATGCACGAGACCGATTCCGGCCCAGAGGAAAGATTCAAGTCTAAGTAAGCACGGCATGAGGCGCTACGCACCCTTGCCCATGACCCCGCAACGGGAACTATGGCCCCGCGGCATGCGTTATACATTATTAACCCACCGCAGCACCCCCGGACTATTCACGCCAAGTGAGGGATTTATCGATTGGACCCTAGGGGGACTGGCGAGCCGTCTTCCTCGGGAGCGGGGTGGAGTGTTGAACTCGACTCACTATGATAACCGTGTCCACCATCAATGGAAGTGAACCCGCGAGCATCATGCTTTATCCAAATTCGACCACTATCGTTTGTATATGATGACCTTGTATCACTGGCTGGCAGTGGTAACGCTTTAAGCCGTTGTAATATAGAGTCCGCGATATTCACTGACCCTGTTTCCTCAAACCCTTCTCTCGTAAAATAGTGGTGCCCACTCCTTCGGAGTTGGAGAGGTTGATCGTGTCAGAATGACGTCACGGTCACGCAACACTTCTATCTTGGCGAGCACCGCATCTCATGTACCCTTCGTATAGTTAGAGGGTAAGATGTGTCAGCCTCCAAACGAAGTGAACTGTAAAGTGTTCGCCT"
# dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
s = Solution()
print s.findRepeatedDnaSequences(dna)