import java.util.stream.IntStream;

class DivideChocolate {
    /*
        cut k times of array, maximize the min of sum of sub-array
     */
    public int maximizeSweetness(int[] sweetness, int K) {
        int low = IntStream.of(sweetness).min().getAsInt();
        int high = IntStream.of(sweetness).sum()/(K+1);

        if (sweetness.length < K + 1) return 0;
//        if (sweetness.length == K + 1) return low;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (canCut(sweetness, mid, K+1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (canCut(sweetness, low, K+1)) return low;
        return low - 1;
    }

    private boolean canCut(int[] S, int minSub, int K) {
        int cuts = 0;
        int sub = 0;
        for (int s: S) {
            sub += s;
            if (sub >= minSub) {
                cuts++;
                sub = 0;
            }
        }
        return cuts >= K;
    }
}