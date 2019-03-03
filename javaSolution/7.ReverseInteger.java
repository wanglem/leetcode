class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10 < pop)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE/10 && Integer.MIN_VALUE%10 > pop)) {
                return 0;
            }
            reversed = reversed * 10 + pop;
        }
        return  reversed;
    }
}