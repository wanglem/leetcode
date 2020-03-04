/*
    G.
    
    swap[i] means you swap A[i] and B[i] at i.
    stay[i] means you DO NOT swap A[i] and B[i] at i.

    Three cases to consider:
    1. See non-increasing: A[i-1] >= A[i] || B[i-1] >= B[i].
        We need either swap i or i-1, not both. Then action at i should be opposite at i-1:
            if i-1 swap then i stay;
            if i-1 stay then i swap.

    2. See non-increasing after previous swap: A[i-1] >= B[i] || B[i-1] >= A[i].
        We should keep i-1 and i same action. The action at i should be same with i-1:
            if i-1 swap then i swap;
            if i-1 stay then i stay.

    3. See increasing (every other cases).
        We can either swap or stay, so new state depends on either previous stay or swap, whichever is smaller:
            newSwap = min(swap, stay) + 1;
            newStay = min(swap, stay).
 */
class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int swap = 1, stay = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i-1] >= A[i] || B[i-1] >= B[i]) {
                int tmp = swap;
                swap = stay + 1;
                stay = tmp;
            } else if (B[i-1] >= A[i] || A[i-1] >= B[i]) {
                swap++;
                stay = stay;
            } else if (A[i-1] < A[i] && B[i-1] < B[i]) {
//            else {
                int min = Math.min(swap, stay);
                swap = min + 1;
                stay = min;
            }
        }
        return Math.min(swap, stay);
    }
}