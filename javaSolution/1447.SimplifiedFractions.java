import java.util.ArrayList;
import java.util.List;

// GCD - greatest common divisor
class SimplifiedFractions{
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) res.add(j + "/" + i);
            }
        }
        return res;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}