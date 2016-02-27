# 273. number to english words
# 1234567 -> One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        def readChunk(d):
            chunk = d%1000
            stack = []
            if chunk >= 100:
                stack.append(rep1To19[chunk/100%10])
                stack.append("Hundred")
                chunk = chunk%100
            if chunk >= 20:
                stack.append(rep20To90[chunk/10%10-2])
                chunk = chunk%10
            if chunk > 0:
                stack.append(rep1To19[chunk])
            return stack[::-1]

        rep1To19 = ["Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        rep20To90 = ["Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        sep = ["Thousand", "Million", "Billion"]
        stack = []
        if num == 0: stack.append(rep1To19[0])
        i = 0
        while num:
            stack.extend(readChunk(num))
            num /= 1000
            if num%1000 != 0: stack.append(sep[i])
            i += 1
        return " ".join(stack[::-1])


s = Solution()
print s.numberToWords(1234567)


