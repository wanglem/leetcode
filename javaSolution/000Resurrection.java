import java.util.*;

class TwoKeyHashMap {
    List<String> myKey1;
    List<String> myKey2;
    List<String> values;

    public TwoKeyHashMap() {
        myKey1 = new ArrayList<>();
    }

    public void put(String k1, String k2, String v) {
        myKey1.add(k1);
        myKey2.add(k2);
        values.add(v);
    }

    public String get(String k1, String k2) {
        int i = 0;
        for (; i < myKey1.size(); i++) {
            if (k1.equals(myKey1.get(i))) break;
        }

        int j = 0;
        for (; j < myKey2.size(); i++) {
            if (k2.equals(myKey2.get(j))) break;
        }

        if (i == j) return values.get(i);

        throw new RuntimeException("Key Not Found");
    }

    public boolean delete(String k1, String k2) {
        int i = 0;
        for (; i < myKey1.size(); i++) {
            if (k1.equals(myKey1.get(i))) break;
        }

        myKey1.remove(i);
        if (k2.equals(myKey2.get(i))) {
            myKey2.remove(i);
        }
        return true;
    }

    public List<String> getMyKey1() {
        return myKey1;
    }

    public List<String> getMyKey2() {
        return myKey2;
    }

    public List<String> getValues() {
        return values;
    }
    
}
