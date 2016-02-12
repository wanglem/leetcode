# 166.
# edge cases:
# 1. negative
# 2. shift right repeats: 1.1(6)
# 3. 0 and unsigned
# 4. extreme case so that many things should be configurabe
# 5. review on how to write generator
class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        sign = 1
        if numerator < 0:
            sign *= -1
            numerator *= -1
        if denominator < 0:
            sign *= -1
            denominator *= -1
        result = str(numerator/denominator)
        remainder = numerator%denominator
        repeatTimes = 10 # say a repeat 10 times is good enough
        offsetTry = 5
        repeating = 1
        decimal = ""
        for d in self.getNextDecimal(remainder, denominator):
            decimal += d
            if len(decimal) >= repeatTimes * repeating+offsetTry:
                (found, rs) = self.findRepeats(decimal, offsetTry, repeating, repeatTimes)
                if found:
                    decimal = rs
                    break
                repeating += 1

            if repeating >= 500: break # if nothing repeats after 100 decimal points, break

        if len(decimal) > 0: result = result + '.' + decimal
        if result != '0' and sign == -1:
            result = "-" + result
        return result


    def findRepeats(self, decimal, offsetTry, length, repeatTimes):
        # return (isFound, repeatString)
        for s in xrange(offsetTry+1):
            checkString = decimal[s:length+s]
            i = 1
            while i < repeatTimes and decimal[s+length*i:(i+1)*length+s] == checkString:
                i += 1
            if i == repeatTimes:
                return (True, decimal[:s] + '(' + checkString + ')')

        return (False, "")

    def getNextDecimal(self, r, d):
        while r!= 0:
            r *= 10
            yield str(r/d)
            if r >= d: r = r%d

        yield ""

