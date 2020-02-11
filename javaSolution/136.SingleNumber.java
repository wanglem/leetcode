import java.util.Arrays;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
 */
class SingleNumber {
    public int singleNumber(int[] A) {
        return Arrays.stream(A).reduce(0, (x, y) -> x^y);
    }
}