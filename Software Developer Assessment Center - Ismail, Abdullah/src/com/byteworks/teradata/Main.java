package com.byteworks.teradata;

public class Main {
    private static final String CONFIG_FILE_NAME = "teradata-world-setup.txt";

    public static void main(String[] args) {
        Graph graph = GraphBuilder.buildGraphFromConfigFile(CONFIG_FILE_NAME);
        ClientRequestProcessor clientRequestProcessor = new ClientRequestProcessor(graph);
        clientRequestProcessor.processRequests();
    }
}
