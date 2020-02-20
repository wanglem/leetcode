import java.util.*;

class SnapshotArray {
    private List<TreeMap<Integer, Integer>> arr;
    private int snapId;
    public SnapshotArray(int length) {
        arr = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arr.add(new TreeMap<>());
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        ensureIndexInbound(index);
        arr.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        ensureIndexInbound(index);
        Map.Entry<Integer, Integer> entry = arr.get(index).floorEntry(snap_id);
        if (entry == null) {
            return 0;
        }
        return entry.getValue();
    }

    private void ensureIndexInbound(int idx) {
        if (idx < 0 || idx >= arr.size()) {
            throw new ArrayIndexOutOfBoundsException("can't do");
        }
    }
}