class CountPrimes {
    public int countPrimes(int n) {
        boolean[] nonPrime = new boolean[n];
        nonPrime[2] = false;
        for (int i = 2; i < n; i++) {
            if (!nonPrime[i]) {
                int nonPrimeNum = i*i;
                while (nonPrimeNum < n) {
                    nonPrime[nonPrimeNum] = true;
                    nonPrimeNum *= i;
                }
            }
        }
        int count = 0;
        for (boolean nonP : nonPrime) {
            if (!nonP) count++;
        }
        return count - 2;

    }
}