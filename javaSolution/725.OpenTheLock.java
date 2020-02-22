import java.util.*;

class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<Integer> de = new HashSet<>();
        for (String d: deadends) {
            de.add(Integer.valueOf(d));
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        int transform = 0;
        int tInt = Integer.valueOf(target);
        while (!Q.isEmpty()) {
            int levelSize = Q.size();
            while(levelSize-- != 0){
                int last = Q.poll();
                if (last == tInt) return transform;
                if (de.contains(last)) continue;
                de.add(last);
                for (int child: flipOne(last)) {
                    Q.offer(child);
                }
            }
            transform++;
        }

        return -1;
    }

    private List<Integer> flipOne(int set) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int idx = (int) Math.pow(10, i);
            int digit = (set % (idx*10))/idx;
            int upFlip = set + (digit == 9 ? -9*idx : idx);
            int downFlip = set - (digit == 0 ? -9*idx : idx);
            res.add(upFlip);
            res.add(downFlip);
        }
        return res;
    }
}