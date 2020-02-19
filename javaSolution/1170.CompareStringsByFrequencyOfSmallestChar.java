import java.util.Arrays;

class CompareStringsByFrequencyOfSmallestChar {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fw = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            fw[i] = f(words[i]);
        }
        Arrays.sort(fw);

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            res[i] = words.length - searchLarger(fw, f(queries[i]));
        }

        return res;
    }

    private int f(String s) {
        if (s.length() == 0) return 0;
        int fre = 0;
        char c = s.charAt(0);

        for (char cs: s.toCharArray()) {
            if (cs < c) {
                fre = 1;
                c = cs;
            } else if (cs == c) {
                fre++;
            }
        }
        return fre;
    }

    private int searchLarger(int[] A, int k) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (A[mid] <= k) left = mid+1;
            else right = mid;
        }

        return left;
    }
}