import java.util.Arrays;

// you can jump maximum of nums[i] at i, try reach the end
class JumpGame {

    // [2,3,1,1,4]
    // O(n2) complexity
    // for each jump, calculate indices it can reach, store min jump to each index.
    public int jumpDP(int[] nums) {
        if (nums.length == 0 || nums[0] == 0) return 0;
        int[] minTo = new int[nums.length];
        Arrays.fill(minTo, Integer.MAX_VALUE);
        minTo[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && j+i < nums.length; j++) {
                minTo[j + i] = Math.min(minTo[j + i], minTo[i] + 1);
            }
        }
        return minTo[nums.length-1];
    }

    /*
        Like a BFS.
        1. Start index 0, find farthest it can reach i. 0 is layer 1.
        2. Farthest reachable between [1, i] is layer 2. Find its farthest it can reach j.
        3. Farthest reachable between [i+1, j] is layer 3.
        4. Keep steps 2 and 3 till reach ends. Each layer is a jump.
     */
    // [2,3,1,1,4]
    public int jumpGreedy(int[] nums) {
        int farthestReach = 0, reach = 0, jump = 0;
        if (nums.length < 2) return jump;
        for (int i = 0; i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
            if (i == farthestReach) {
                jump++;
                farthestReach = reach;
            }
            if (farthestReach >= nums.length-1) break;
        }
        return jump;
    }
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}