/*
    idea:
    Enumerate all possibilities of three numbers: a, b, c, e
    1. [a] -> see b. If (a < b) [a, b] else [b]
    2. [a, b] -> see c. If (c > b) true else if (a<b<c) [a, c] else if (c < a) [c, b]
        2a. when [c ,b]. Suppose we see e.
            if (e > b) Then either [a, b, e] (previous had a) or [c, b, e] (c occur before)
            if (c < e < b) -> [c, e]: back to step 2.
            if (e < a) -> [e, b]: back to step 2a.
 */
class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        return true;
    }
}