import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    // maintains insertion order on iteration of this LinkedHashMap
    // put op puts last of linkedhashmap
    private LinkedHashMap<Integer, Integer> lhm;
    private int capacity;
    public LRUCache(int capacity) {
        lhm = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!lhm.containsKey(key)) {
            return -1;
        }
        int returnVal = lhm.get(key);
        lhm.remove(key);
        lhm.put(key, returnVal);
        return returnVal;
    }

    public void put(int key, int value) {
        lhm.remove(key);
        if (lhm.size() == capacity) {
            Map.Entry<Integer, Integer> first = lhm.entrySet().iterator().next();
            lhm.remove(first.getKey());
        }
        lhm.put(key, value);
    }
}