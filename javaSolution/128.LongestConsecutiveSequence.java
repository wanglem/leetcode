import java.util.*;

class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n: nums) numSet.add(n);

        Map<Integer, Integer> count = new HashMap<>();
        int longest = 0;
        for (int n: nums) {
            int seq = 0;
            int cur = n;
            while (numSet.contains(cur)) {
                seq++;
                if (count.containsKey(cur+1)) {
                    count.put(n, count.get(cur+1)+seq);
                    count.remove(cur+1);
                    break;
                }
                cur++;
            }
            if (!count.containsKey(n)) count.put(n, seq);
            longest = Math.max(longest, count.get(n));
        }
        return longest;
    }

}