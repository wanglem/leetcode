import java.util.*;

/*
    Google.

    1. Add a virtual house(0) that has well to each house(i) with pipe cost wells[i].
        This simplifies problem and remove node weight, but only edge weight.
    2. Sort all edges by cost, try build pipe from cheap to expensive. Since we have house(0) with water, we say
        there's at least one well, we can starts lay down cheapest pipe to minimize the cost.
        a. This connects the graph node.
        b. Use UnionFind to track nodes those are connected, if a node is already connected, then skip (no cost).
        c. Connect to house(0) means build a well, but we only care cost.
        d. At least one house will connect to house(0) so we at least build one well - solves edge case.
 */
class OptimizeWaterDistributionInAVillage {
    private int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        uf = new int[n+1];
        List<int[]> pws = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < n; i++) {
            pws.add(new int[]{0, i+1, wells[i]});
        }
        Collections.addAll(pws, pipes);

        pws.sort(Comparator.comparingInt(x -> x[2]));

        int cost = 0;
        for (int[] pw: pws) {
            int p0 = find(pw[0]), p1 = find(pw[1]);
            if (p1 != p0) {
                uf[p0] = p1;
                cost += pw[2];
            }
        }
        return cost;
    }

    private int find(int x) {
        if (uf[x] != x) uf[x] = find(uf[x]);
        return uf[x];
    }
}