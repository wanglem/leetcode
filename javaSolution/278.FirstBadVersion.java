/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class FirstBadVersion {
    public int firstBadVersion(int n) {
        int i = 0, j = n;
        while (i < j) {
            int mid = (i+j)/2;
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        if (isBadVersion(i)) return i;
        return -1;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}