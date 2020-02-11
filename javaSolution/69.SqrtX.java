class SqrtX {
    // pay attention to int overflow and divide by zero problems.
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int lo = 0, hi = x;
        while (lo < hi) {
            int mid = lo + (hi-lo) / 2;
            if (mid == x/mid) return mid;
            else if (mid > x/mid) hi = mid;
            else if ((mid+1) > x/(mid+1)) return mid;
            else lo = mid+1;
        }
        return lo;
    }
}