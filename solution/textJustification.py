# 68.
class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        rs = []
        lineLen = 0
        line = []
        # dummy tail to deal with a corner case
        words.append('a'*(maxWidth+1))
        for w in words:
            lineLen += len(w)
            if lineLen == 0: continue
            if lineLen == maxWidth:
                line.append(w)
                rs.append(" ".join(line))
                line = []
                lineLen = 0
            elif lineLen < maxWidth:
                line.append(w)
                lineLen += 1
            else:
                padding = maxWidth - lineLen + len(w) + 1
                if len(line) > 1: 
                    wordPadding = padding / (len(line) - 1)
                    remain = padding % (len(line) - 1)
                    for i in xrange(len(line)-1):
                        line[i] += " "*wordPadding
                        if remain > 0:
                            line[i] += " "
                            remain -= 1
                else:
                    line[0] += " "*padding
                rs.append(" ".join(line))
                lineLen= len(w)+1
                line = [w]

        return rs

t = ["This", "is", "an", "example", "of", "text", "justification."]
s = Solution()
print s.fullJustify([""], 0)