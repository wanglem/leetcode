import java.util.TreeSet;

// Google
/*
    The key idea is:
        This is 1 row, so max distance of all is the the max distance between 2 adjacent students!
        Pay attention to index offset
 */
class ExamRoom {
    private TreeSet<Integer> seated;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        this.seated = new TreeSet<>();
    }

    public int seat() {
        int seat = 0;
        if (seated.size() > 0) {
            Integer prev = null;
            int distance = 0;
            if (seated.first() != 0) {
                distance = seated.first();
            }
            for (Integer cur : seated) {
                if (prev != null) {
                    int curDistance = (cur - prev)/2;
                    if (curDistance > distance) {
                        distance = curDistance;
                        seat =  prev + curDistance;
                    }
                }
                prev = cur;
            }
            if (prev != N - 1 && N - 1 - prev > distance) {
                seat = N - 1;
            }
        }
        seated.add(seat);
        return seat;
    }

    public void leave(int p) {
        // TreeSet.remove() is log(n)
        seated.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */