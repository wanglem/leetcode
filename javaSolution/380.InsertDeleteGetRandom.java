import java.util.*;

// BB
/*
    Using an array to track all records
        O(1) random access for getRandom
        O(1) for insert (append operation)
        O(1) delete for swapping with last value.

    Using HashMap to record element location (index in array).

    Follow up: elements are weighted, getRandom should consider weights:
        1. sum all weights -> weightSum
        2. get a random number between [0, weightSum] -> rand
        3. loop through element weight -> i
            a. if rand < weights[i], return i
            b. rand -= weights[i]
            c. continue step 3.
 */
class RandomizedSet {

    private List<Integer> elements;
    private Map<Integer, Integer> idx;
    private Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        elements = new ArrayList<>();
        idx = new HashMap<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        elements.add(val);
        idx.put(val, elements.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) return false;
        int keyIdx = idx.get(val);
        elements.set(keyIdx, elements.get(elements.size()-1));
        idx.put(elements.get(keyIdx), keyIdx);
        idx.remove(val);
        elements.remove(elements.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomKey = r.nextInt(elements.size());
        return elements.get(randomKey);
    }
}