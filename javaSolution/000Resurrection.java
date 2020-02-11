import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */
class Resurrection {
    public int candy(int[] R) {
        int n = R.length;
        int decreasingStart = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n + 1; i++) {
            if (i == n || R[i] < R[i-1]) {
                for (int j = i-1; j > decreasingStart; j--) {
                    candies[j]++;
                }
                if (decreasingStart < n - 1
                        && candies[decreasingStart] <= candies[decreasingStart+1]) {
                    candies[decreasingStart]++;
                }
            } else if (R[i] > R[i-1]) {
                candies[i] = candies[i-1] + 1;
                decreasingStart = i;
            } else {
                candies[i] = candies[i-1];
            }
        }

        return Arrays.stream(candies).sum();
    }
}