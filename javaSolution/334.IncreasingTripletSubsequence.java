/*
    idea:
    Enumerate all possibilities of three numbers: a, b, c, e
    1. [a] -> see b. If (a < b) [a, b] else [b]
    2. [a, b] -> see c. If (c > b) true else if (a<c<b) [a, c] else if (c < a) [c, b]
        2a. when [c ,b]. Suppose we see e.
            if (e > b) Then either [a, b, e] (previous had a) or [c, b, e] (c occur before)
            if (c < e < b) -> [c, e]: back to step 2.
            if (e < a) -> [e, b]: back to step 2a.
 */
class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
}