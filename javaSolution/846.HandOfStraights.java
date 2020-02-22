import java.util.Map;
import java.util.TreeMap;

class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> numCount = new TreeMap<>();
        if (hand.length % W != 0) return false;
        for (int h: hand) {
            numCount.put(h, numCount.getOrDefault(h, 0) + 1);
        }
        for (int i = 0; i < hand.length / W; i++) {
            while (numCount.firstEntry().getValue() == 0) {
                numCount.remove(numCount.firstKey());
            }
            int smallest = numCount.firstKey();
            for (int j = 0; j < W; j++) {
                int key = smallest+j;
                if (numCount.getOrDefault(key, 0) == 0) return false;
                numCount.put(key, numCount.get(key)-1);
            }
        }
        return true;
    }

}