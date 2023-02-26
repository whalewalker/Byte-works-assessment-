package com.byteworks.teradata;
import java.io.*;

public class ClientRequestProcessor {

    private static final String CLIENT_REQUEST_PREFIX = "client-request-";
    private static final String CLIENT_REQUEST_SUFFIX = ".txt";
    private static final String END_STRING = "END";
    private final Graph graph;

    public ClientRequestProcessor(Graph graph) {
        this.graph = graph;
    }

    /**
     * Processes client requests by reading input files and writing output files.
     * For each client request file, the method generates an output file "client-response-counter.txt",
     * where counter is the request file number.
     */
    public void processRequests() {
        int limit = 1;
        for (int counter = 1; counter <= limit  ; counter++) {
            String requestFileName = CLIENT_REQUEST_PREFIX + counter + CLIENT_REQUEST_SUFFIX;
            if (!processClientRequests(requestFileName, counter)) {
                break;
            }
        }
    }

    /**
     * Processes a single client request file and writes the response to an output file.
     *
     * @param requestFileName the name of the client request file
     * @param counter         the number of file request
     * @return true if the request was successfully processed, false otherwise
     */
    public boolean processClientRequests(String requestFileName, int counter) {
        String responseFileName = "client-response-" + counter + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(requestFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(responseFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(END_STRING)) {
                    break;
                }
                String[] parts = line.split(",");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                double threshold = Double.parseDouble(parts[2]);
                boolean[] visited = new boolean[graph.getSize() + 1];
                for (int i = 0; i < visited.length; i++) {
                    visited[i] = false;
                }
                boolean isReachable = isReachable(source, destination, threshold, visited);
                String result = isReachable ? "YES" : "NO";
                bw.write(result);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * Checks if there is a path from the source node to the destination node in the graph
     * such that each edge along the path has a probability greater than or equal to the threshold.
     *
     * @param source      the source node
     * @param destination the destination node
     * @param threshold   the probability threshold for each edge
     * @param visited     an array indicating whether a node has been visited before
     * @return true if a path from source to destination exists, false otherwise
     */
    private boolean isReachable(int source, int destination, double threshold, boolean[] visited) {
        visited[source] = true;
        if (source == destination) {
            return true;
        }
        CustomList<Node> neighbors = graph.getNeighbors(source);
        for (int i = 0; i < neighbors.size(); i++) {
            Node neighbor = neighbors.get(i);
            if (!visited[neighbor.getNode()] && neighbor.getProbability() >= threshold) {
                if (isReachable(neighbor.getNode(), destination, threshold, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


}
