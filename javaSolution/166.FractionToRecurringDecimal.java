import java.util.*;

class FractionToRecurringDecimal  {
    final class FPair implements Comparable<FPair> {
        int k;
        int v;
        FPair(int a, int b) {
            k = a;
            v = b;
        }

        @Override
        public boolean equals(Object obj) {
            FPair o = (FPair) obj;
            return k == o.k && v == o.v;
        }

        @Override
        public int hashCode() {
            return k*31+v*17;
        }

        @Override
        public int compareTo(FPair o) {
            return hashCode() - o.hashCode();
        }
    }

    public String fractionToDecimal(int numerator, int denominator) {
        TreeSet<FPair> seen = new TreeSet<>();

        StringBuilder vr = new StringBuilder();
        int r = -1;
        int v = -1;
        boolean recurring = false;
        if (numerator < denominator) vr.append(0);
        while (numerator > denominator) {
            vr.append(numerator/denominator);
            numerator %= denominator;
        }

        while (numerator != 0) {
            numerator *= 10;
            r = numerator % denominator;
            v = numerator / denominator;
            FPair p = new FPair(r, v);
            if (seen.contains(p)) {
                vr.append(".");
                for (FPair fp : seen) {
                    if (!recurring && (fp.k == p.k && fp.v == p.v)) {
                        recurring = true;
                        vr.append("(");
                    }
                    vr.append(fp.v);
                }
                vr.append(")");
                break;
            } else {
                seen.add(p);
            }
            numerator = r;
        }
        if (!recurring && !seen.isEmpty()) {
            vr.append(".");
            seen.forEach(x -> vr.append(x.v));
        }
        return vr.toString();
    }
}