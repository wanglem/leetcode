import java.util.Arrays;

/*
    maitain n size array, each prime points to its current index. index++ when selected.
    ++ all when same value to dedupe. i.e. 2*7 and 7*2
 */
class NthUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[][] candidates = new int[primes.length][2];
        for (int i = 0; i < primes.length; i++) {
            candidates[i][0] = primes[i];
            candidates[i][1] = 0;
        }

        int[] nth = new int[n];
        nth[0] = 1;
        for (int i = 0; i < n - 1; i++){
            int nextPrime = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int nextPrimeCandidate = candidates[j][0] * nth[candidates[j][1]];
                if (nextPrime > nextPrimeCandidate) {
                    nextPrime = nextPrimeCandidate;
                }
            }
            for (int j = 0; j < primes.length; j++) {
                int nextPrimeCandidate = candidates[j][0] * nth[candidates[j][1]];
                if (nextPrime == nextPrimeCandidate) candidates[j][1]++;
            }
            nth[i+1] = nextPrime;
        }
        return nth[n-1];
    }
}