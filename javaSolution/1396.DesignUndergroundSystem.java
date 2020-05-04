import java.util.*;

class DesignUndergroundSystem {
    private class Itinerary {
        String from;
        String to;
        Itinerary(String f, String t) {
            from = f;
            to = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Itinerary itinerary = (Itinerary) o;
            return Objects.equals(from, itinerary.from) &&
                    Objects.equals(to, itinerary.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    private class CheckedIn {
        String from;
        int startTime;
        CheckedIn(String f, int t) {
            from = f;
            startTime = t;
        }
    }

    private Map<Integer, CheckedIn> checkedIn; // id -> CheckedIn
    private Map<Itinerary, List<Integer>> trip; // Itinerary -> [tripTimes]
    public DesignUndergroundSystem() {
        checkedIn = new HashMap<>();
        trip = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkedIn.put(id, new CheckedIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckedIn in = checkedIn.get(id);
        Itinerary itinerary = new Itinerary(in.from, stationName);
        if (!trip.containsKey(itinerary)) {
            trip.put(itinerary, new ArrayList<>());
        }
        trip.get(itinerary).add(t - in.startTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        Itinerary itinerary = new Itinerary(startStation, endStation);
        return trip.get(itinerary).stream().mapToInt(x -> x).average().getAsDouble();
    }
}