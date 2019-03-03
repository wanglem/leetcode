class PalandromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int length = 0;
        int lengthTest = x;
        while (lengthTest > 0) {
            lengthTest /= 10;
            length++;
        }
        while (length > 1) {
            int leftDenom = (int) Math.pow(10, length - 1);
            int rightDenom = 10;
            if (x / leftDenom != x % rightDenom) {
                return false;
            }
            x %= leftDenom;
            x /= rightDenom;
            length -= 2;
        }
        return true;
    }
}