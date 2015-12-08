# 43. 
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        # "3155"
        # "9107"
        total = ""
        i = len(num2) - 1
        while i >= 0:
            current = self.multiplySingle(num2[i], num1)
            total = self.add(total, current + "0"*(len(num2)-i-1))
            i -= 1

        return total

    def add(self, n1, n2):
        carry = 0
        i, j = len(n1)-1, len(n2)-1
        result = ""
        while i >= 0 or j >= 0:
            digit = carry
            if i >= 0 : digit += int(n1[i])
            if j >= 0 : digit += int(n2[j])
            carry = digit / 10
            result = str(digit % 10) + result
            i -= 1
            j -= 1

        if carry > 0:
            result = str(carry) + result

        return result

    def multiplySingle(self, d, num):
        assert len(d) == 1
        d = int(d)
        if d == 0: return "0"
        i, carry = len(num) - 1, 0
        result = ""
        while i >= 0:
            tmp = d * int(num[i]) + carry
            carry = tmp / 10
            result = str(tmp % 10) + result
            i -= 1
        if carry > 0: result = str(carry) + result

        return result

s = Solution()
print s.multiply("9369162965141127216164882458728854782080715827760307787224298083754", "7204554941577564438")

