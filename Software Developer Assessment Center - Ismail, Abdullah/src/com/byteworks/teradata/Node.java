package com.byteworks.teradata;

public class Node {
    private final int node;
    private final double probability;

    public Node(int node, double probability) {
        this.node = node;
        this.probability = probability;
    }

    /**
     * Get the integer identifier for this node.
     *
     * @return the integer identifier for the node.
     */
    public int getNode() {
        return node;
    }

    /**
     * Get the probability value associated with this node.
     *
     * @return the probability value associated with the node.
     */
    public double getProbability() {
        return probability;
    }
}
