package com.byteworks.teradata;


public class Graph {
    private final int size;
    private final CustomMap<Integer, CustomList<Node>> adjacencyList;

    public Graph(int size, CustomMap<Integer, CustomList<Node>> adjacencyList) {
        this.size = size;
        this.adjacencyList = adjacencyList;
    }

    /**
     * Returns the number of nodes in the graph.
     *
     * @return the number of nodes in the graph
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the adjacency list of the graph. Each entry in the map represents a node in the graph, and the value
     * associated with the entry is the list of neighbors of the node.
     *
     * @return the adjacency list of the graph
     */
    public CustomMap<Integer, CustomList<Node>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Returns the list of neighbors of the specified node in the graph.
     *
     * @param node the node to retrieve the list of neighbors for
     * @return the list of neighbors of the specified node
     */
    public CustomList<Node> getNeighbors(int node) {
        return getAdjacencyList().get(node);
    }

}
