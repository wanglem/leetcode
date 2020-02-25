import java.util.*;
import java.util.stream.Collectors;

/*
    Google. Not passing all test cases, but idea should be correct.
 */
class OptimalAccountBalancing {

    // transactions[i] -> [from, to, amount]
    public int minTransfers(int[][] transactions) {
        // Map<From, Map<To, Money>>
        Map<Integer,Integer> graph = new HashMap<>();
        for (int[] t: transactions) {
            graph.put(t[0], graph.getOrDefault(t[0], 0) - t[2]);
            graph.put(t[1], graph.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> send = graph.values().stream().filter(x -> x < 0).map(x -> -1*x).collect(Collectors.toList());
        List<Integer> take = graph.values().stream().filter(x -> x > 0).collect(Collectors.toList());
        return settle(send, take, 0, 0);
    }

    /*
        After get net worth, s is send, t is take, both positive values.
        Run DFS on all send/take combinations and get minimum transfer count.
     */
    private int settle(List<Integer> s, List<Integer> t, int si, int ti) {
        if (si == s.size()) return t.size() - ti;
        if (ti == t.size()) return s.size() - si;

        int min = Integer.MAX_VALUE;
        for (int i = si; i < s.size(); i++) {
            for (int j = ti; j < t.size(); j++) {
                if (s.get(i) > t.get(j)) {
                    s.set(i, s.get(i) - t.get(j));
                    min = Math.min(settle(s, t, i, j+1), min);
                    s.set(i, s.get(i) + t.get(j));
                } else if (s.get(i) < t.get(j)) {
                    t.set(j, t.get(j) - s.get(i));
                    min = Math.min(settle(s, t, i+1, j), min);
                    t.set(j, t.get(j) + s.get(i));
                } else {
                    min = Math.min(settle(s, t, i+1, j+1), min);
                }
            }
        }
        return min+1;
    }

}