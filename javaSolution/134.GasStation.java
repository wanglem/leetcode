class GasStation {
    /*
        1. If total gas left >=0, then there must be a way to finish.
        2. loop through once and find the start position.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (cost.length != gas.length) return -1;

        int gasLeft = 0;
        int start = 0;
        int totalGasLeft = 0;
        for (int i = 0; i < cost.length; i++) {
            totalGasLeft += gas[i] - cost[i];
            gasLeft += gas[i] - cost[i];

            if (gasLeft < 0) {
                gasLeft = 0;
                start = i+1;
            }
        }

        return totalGasLeft >=0 ? start % cost.length : -1;
    }
}