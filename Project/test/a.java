import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class a {

    static class Location {
        String name;

        Location(String name) {
            this.name = name;
        }
    }

    static class Edge {
        Location source, destination;
        int weight;
        int time;

        Edge(Location source, Location destination, int weight, int time) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.time = time;
        }
    }

    static class Path {
        List<Location> locations;
        int totalWidth;
        int totalTime;

        Path(List<Location> locations, int totalWidth, int totalTime) {
            this.locations = locations;
            this.totalWidth = totalWidth;
            this.totalTime = totalTime;
        }
    }

    public static void main(String[] args) {
        deliverySystem();
    }

    static void deliverySystem() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create locations
            Location mirpur10 = new Location("mirpur10");
            Location mirpur1 = new Location("mirpur1");
            Location sawrapara = new Location("sawrapara");
            Location kajipara = new Location("kajipara");
            Location agargao = new Location("agargao");

            List<Location> locations = Arrays.asList(mirpur10, mirpur1, sawrapara, kajipara, agargao);

            // Randomly choose starting and destination locations
            Location startLocation = getRandomLocation(locations);
            Location endLocation = getRandomLocation(locations);

            System.out.println("Your current location: " + startLocation.name);
            System.out.println("Your destination location: " + endLocation.name);

            // Run Bellman-Ford algorithm
            Path shortestPath = bellmanFord(locations, createEdges(), startLocation, endLocation);

            // Print the results
            System.out.println("\nShortest Path:");
            printPath(shortestPath.locations);
            System.out.println("Minimum width along the path: " + shortestPath.totalWidth);
            System.out.println("Total time for delivery: " + shortestPath.totalTime + " minutes");
        }
    }

    static List<Edge> createEdges() {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(new Location("mirpur10"), new Location("mirpur1"), 3, getRandomTravelTime()));
        edges.add(new Edge(new Location("mirpur1"), new Location("sawrapara"), 5, getRandomTravelTime()));
        edges.add(new Edge(new Location("sawrapara"), new Location("agargao"), 2, getRandomTravelTime()));
        edges.add(new Edge(new Location("mirpur10"), new Location("kajipara"), 4, getRandomTravelTime()));
        edges.add(new Edge(new Location("kajipara"), new Location("agargao"), 6, getRandomTravelTime()));
        return edges;
    }

    static Path bellmanFord(List<Location> locations, List<Edge> edges, Location start, Location end) {
        int numLocations = locations.size();
        Map<Location, Integer> distance = new HashMap<>();
        Map<Location, Location> predecessor = new HashMap<>();

        // Initialize distances and predecessors
        for (Location location : locations) {
            distance.put(location, Integer.MAX_VALUE);
            predecessor.put(location, null);
        }
        distance.put(start, 0);

        // Relax edges repeatedly
        for (int i = 0; i < numLocations - 1; i++) {
            for (Edge edge : edges) {
                int newDistance = distance.get(edge.source) + edge.weight;
                if (newDistance < distance.get(edge.destination)) {
                    distance.put(edge.destination, newDistance);
                    predecessor.put(edge.destination, edge.source);
                }
            }
        }

        // Reconstruct the path
        List<Location> pathLocations = new ArrayList<>();
        Location current = end;
        while (current != null) {
            pathLocations.add(current);
            current = predecessor.get(current);
        }
        Collections.reverse(pathLocations);

        // Calculate total width and time
        int totalWidth = 0;
        int totalTime = 0;
        for (int i = 0; i < pathLocations.size() - 1; i++) {
            Location currentLocation = pathLocations.get(i);
            Location nextLocation = pathLocations.get(i + 1);
            for (Edge edge : edges) {
                if (edge.source.equals(currentLocation) && edge.destination.equals(nextLocation)) {
                    totalWidth += edge.weight;
                    totalTime += edge.time;
                    break;
                }
            }
        }

        return new Path(pathLocations, totalWidth, totalTime);
    }

    static Location getRandomLocation(List<Location> locations) {
        Random rand = new Random();
        return locations.get(rand.nextInt(locations.size()));
    }

    static int getRandomTravelTime() {
        Random rand = new Random();
        return rand.nextInt(30) + 10; // Random travel time between 10 and 40 minutes
    }

    static void printPath(List<Location> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i).name);
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
