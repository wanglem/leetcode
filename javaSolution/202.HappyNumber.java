import java.util.HashSet;

// sum of square of each digits, n times finally converge to 1
class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int next = 0;
        while (!seen.contains(n)) {
            seen.add(n);
            while (n > 0) {
                next += Math.pow(n%10, 2);
                n /= 10;
            }
            if (next == 1) {
                return true;
            }
            n = next;
            next = 0;
        }
        return false;
    }
}