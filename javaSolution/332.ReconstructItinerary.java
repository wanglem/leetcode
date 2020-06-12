import java.util.*;

class ReconstructItinerary {
    private Map<String, PriorityQueue<String>> visits;
    private List<String> route;
    public List<String> findItinerary(List<List<String>> tickets) {
        visits = new HashMap<>();
        route = new ArrayList<>();
        for (List<String> pair: tickets) {
            visits.putIfAbsent(pair.get(0), new PriorityQueue<>());
            visits.get(pair.get(0)).add(pair.get(1));
        }
        visit("JFK");
        return route;

    }
    
    private void visit(String airport) {
        // route.add(airport);
        PriorityQueue<String> to = visits.get(airport);
        while (to != null && !to.isEmpty()) {
            visit(to.poll());
        }
        /*
         * add this at the end so that if lexically smaller AIRPORT
         * get processed first and reaches the end. Following loops will
         * insert other AIRPORTs before it.
         */
        route.add(0, airport);
    }
}