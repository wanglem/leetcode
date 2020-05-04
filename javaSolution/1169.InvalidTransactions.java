import java.util.*;

// BB
// I don't get this logic. If one trans > 1000, second trans < 1000 within 60 min diff city. Is second invalid?
class InvalidTransactions {

    private class Record {
        int id;
        String name;
        int time;
        int amount;
        String city;

        Record(int id, String n, int b, int a, String c) {
            this.id = id;
            name = n;
            time = b;
            amount = a;
            city = c;
        }

        @Override
        public String toString() {
            return String.format("%s,%d,%d,%s", name, time, amount, city);
        }

    }
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, TreeMap<Integer, Record>> nameToTimes = new HashMap<>();
        int id = 0;
        for (String t: transactions) {
            String[] splited = t.split(",");
            Record r = new Record(id++, splited[0], Integer.valueOf(splited[1]), Integer.valueOf(splited[2]), splited[3]);
            if (!nameToTimes.containsKey(r.name)) {
                nameToTimes.put(r.name, new TreeMap<>());
            }
            nameToTimes.get(r.name).put(r.time, r);
        }

        List<String> invalids = new ArrayList<>();
        boolean[] isInvalid = new boolean[id];
        for (TreeMap<Integer, Record> sameName: nameToTimes.values()) {
            for (Record r: sameName.values()) {
                if (r.amount > 1000 && !isInvalid[r.id]) {
                    invalids.add(r.toString());
                    isInvalid[r.id] = true;
                    continue;
                }
                boolean hasInvalidOverlap = false;
                for (Record possibleInvalid: sameName.subMap(r.time - 60, true, r.time + 60, true).values()) {
                    if (!possibleInvalid.city.equals(r.city) && !isInvalid[possibleInvalid.id]) {
                        hasInvalidOverlap = true;
                        isInvalid[possibleInvalid.id] = true;
                        invalids.add(possibleInvalid.toString());
                    }
                }
                if (hasInvalidOverlap && !isInvalid[r.id]) {
                    invalids.add(r.toString());
                    isInvalid[r.id] = true;
                }

            }
        }
        return invalids;
    }
}