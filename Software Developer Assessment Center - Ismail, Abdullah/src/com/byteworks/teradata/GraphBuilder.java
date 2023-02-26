package com.byteworks.teradata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GraphBuilder {

    /**
     * Builds a graph from a configuration file containing the number of nodes and edges
     * <p>
     * with probabilities for each edge.
     *
     * @param configFileName the file name of the configuration file
     * @return the graph constructed from the configuration file
     */
    public static Graph buildGraphFromConfigFile(String configFileName) {
        int n = 0;
        CustomMap<Integer, CustomList<Node>> adjacencyList =  new CustomMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(configFileName))) {
            n = Integer.parseInt(br.readLine().trim());

            for (int i = 1; i <= n; i++) {
                adjacencyList.put(i, new CustomList<>());
            }

            for (int i = 1; i < n; i++) {
                String[] parts = br.readLine().split(",");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                double p = Double.parseDouble(parts[2]) / 100.0;
                adjacencyList.get(u).add(new Node(v, p));
                adjacencyList.get(v).add(new Node(u, p));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Graph(n, adjacencyList);
    }
}
