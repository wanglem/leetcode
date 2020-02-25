import java.util.*;

class SplitArrayIntoConsecutiveSubsequence {

    /*
        Greedy Answer.
        1. get frequency count.
        2. For each number, do in order:
            a. add to an existing sequence
            b. start a new sequence
        3. Trick is to use a hashmap to record end->start of a sequence.
            Each entry in HashMap must be a valid sequence.
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        for (int n: nums) {
            left.put(n, left.getOrDefault(n, 0)+1);
        }
        Map<Integer, Integer> seq = new HashMap<>();

        for (int n: nums) {
            if (left.get(n) == 0) continue;
            left.put(n, left.get(n)-1);
            if (seq.getOrDefault(n-1, 0) > 0) {
                seq.put(n-1, seq.get(n-1)-1);
                seq.put(n, seq.getOrDefault(n, 0)+1);
            } else if (left.getOrDefault(n+1, 0) > 0 && left.getOrDefault(n+2, 0) > 0) {
                left.put(n+1, left.get(n+1)-1);
                left.put(n+2, left.get(n+2)-1);
                seq.put(n+2, seq.getOrDefault(n+2, 0)+1);
            } else {
                return false;
            }
        }
        return true;
    }
}