import java.util.*;

/*
    G.
    cloest bike to worker.
        1. same worker length -> choose smaller worker index.
        2. same bike length -> choose smaller bike index.

    M workers, N bikes.
    for all M*N pairs, sort them by distance, worker index then bike index.
    pair up while keep tracking who's paired.
 */
class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]> allPairs = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) +
                        Math.abs(workers[i][1] - bikes[j][1]);
                allPairs.add(new int[] {distance, i, j});
            }
        }

        allPairs.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[2], o2[2]);
        });

        int[] assignBikes = new int[workers.length];
        Arrays.fill(assignBikes, -1);
        boolean[] seenBikes = new boolean[bikes.length];

        for (int[] pair: allPairs) {
            if (assignBikes[pair[1]] >= 0 || seenBikes[pair[2]]) continue;
            assignBikes[pair[1]] = pair[2];
            seenBikes[pair[2]] = true;
        }

        return assignBikes;
    }
}