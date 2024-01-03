/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.foodd;

/**
 *
 * @author fab5k
 */


  import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class FoodD {

    static class Location {
        String name;

        Location(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    static class Edge {
        Location source, destination;
        int time;
        int cost;

        Edge(Location source, Location destination, int time, int cost) {
            this.source = source;
            this.destination = destination;
            this.time = time;
            this.cost = cost;
        }
    }

    static class Path {
        List<Location> locations;
        int totalTime;
        int totalCost;

        Path(List<Location> locations, int totalTime, int totalCost) {
            this.locations = locations;
            this.totalTime = totalTime;
            this.totalCost = totalCost;
        }
    }

    static Path bellmanFord(List<Location> locations, List<Edge> edges, Location start, Location end) {
        Map<Location, Integer> totalTime = new HashMap<>();
        Map<Location, Integer> totalCost = new HashMap<>();
        Map<Location, Location> predecessor = new HashMap<>();

        // Initialize times and costs, set to infinity initially
        for (Location location : locations) {
            totalTime.put(location, Integer.MAX_VALUE);
            totalCost.put(location, Integer.MAX_VALUE);
        }

        // Set time and cost for the starting location to 0
        totalTime.put(start, 0);
        totalCost.put(start, 0);

        // Relax edges repeatedly
        for (int i = 0; i < locations.size() - 1; i++) {
            for (Edge edge : edges) {
                int newTime = totalTime.get(edge.source) + edge.time;
                int newCost = totalCost.get(edge.source) + edge.cost;

                if (newTime < totalTime.get(edge.destination) || (newTime == totalTime.get(edge.destination) && newCost < totalCost.get(edge.destination))) {
                    totalTime.put(edge.destination, newTime);
                    totalCost.put(edge.destination, newCost);
                    predecessor.put(edge.destination, edge.source);
                }
            }
        }

        // Reconstruct the path
        List<Location> path = new ArrayList<>();
        Location current = end;
        while (current != null) {
            path.add(current);
            current = predecessor.get(current);
        }
        Collections.reverse(path);

        return new Path(path, totalTime.get(end), totalCost.get(end));
    }
public static void DeliverySystem(){
        // Create locations
        Location dhaka = new Location("Dhaka");
        Location rajshahi = new Location("Rajshahi");
        Location faridpur = new Location("Faridpur");
        Location narayanganj = new Location("Narayanganj");
        Location bogra = new Location("Bogra");

        List<Location> locations = Arrays.asList(dhaka, rajshahi, faridpur, narayanganj, bogra);

        // Create edges with randomized time and cost values
        List<Edge> edges = new ArrayList<>();
        Random rand = new Random();

       // Example: Randomly choose 50% of possible connections
for (Location source : locations) {
    for (Location destination : locations) {
        if (!source.equals(destination) && rand.nextDouble() < 0.5) {
            int time = rand.nextInt(10) + 1;
            int cost = rand.nextInt(31) + 10;
            edges.add(new Edge(source, destination, time, cost));
        }
    }
}


        // Get a random starting location
        Location startLocation = locations.get(rand.nextInt(locations.size()));

        // Get user input for the ending location
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your destination location (Dhaka, Rajshahi, Faridpur, Narayanganj, Bogra): ");
        String endLocationInput = scanner.nextLine().trim();

        Location endLocation = null;
        for (Location location : locations) {
            if (location.name.equalsIgnoreCase(endLocationInput)) {
                endLocation = location;
                break;
            }
        }

        if (endLocation == null) {
            System.out.println("Invalid destination location. Exiting the program.");
             System.out.println("Enter your destination location (Dhaka, Rajshahi, Faridpur, Narayanganj, Bogra): ");
         endLocationInput = scanner.nextLine().trim();
        }

        // Run Bellman-Ford algorithm
        Path shortestPath = bellmanFord(locations, edges, startLocation, endLocation);
         int cost = (int)(Math.random() * 40); 
        int time;
        if (shortestPath.totalTime*60/2 > 60 || shortestPath.totalTime*60/2 <10) {
            time=rand.nextInt((50 - 10) + 1) + 10; 
        }
        else { time= shortestPath.totalTime*60/2; }

         if (shortestPath.totalCost*40/15 > 50 || shortestPath.totalCost*60/2 <10) {
            cost=rand.nextInt((40 - 10) + 1) + 10; 
        }
        else { cost= shortestPath.totalCost*40/15; }
        
       
        // Print the results
        System.out.println("Random starting location: " + startLocation.name);
        System.out.println("Shortest path: " + shortestPath.locations.toString());
        System.out.println("Total time for delivery: " +Math.abs(time)+ " min ");
        System.out.println("Total delivery cost: $" +Math.abs(cost));
}

    public static void main(String[] args) {
    DeliverySystem();

        // Display a simplified directed graph representation
        // System.out.println("\nDirected Graph (Simplified Representation):");
        // for (Edge edge : edges) {
        //     System.out.println(edge.source.name + " -> " + edge.destination.name +
        //             " (Time: " + edge.time + " hours, Cost: $" + edge.cost + ")");
        // }
    }
}


