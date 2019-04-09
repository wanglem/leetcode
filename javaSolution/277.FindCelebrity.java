// fb
/*
 loop through
    1. if a knows a+1, a definitely not celebrity, a+1 might be
    2. if a not knows a+1, a+1 definitely not celebrity, a might be
    3. has one candidate at end, loop through again to make sure
 */
class FindCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
            candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
    private boolean knows(int a, int b) {
        return true;
    }
}
