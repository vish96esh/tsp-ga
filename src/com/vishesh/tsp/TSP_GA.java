package com.vishesh.tsp;

public class TSP_GA {
	public static void main(String[] args) {

        Node node = new Node(60, 200);
        Graph.addNode(node);
        Node node2 = new Node(180, 200);
        Graph.addNode(node2);
        Node node3 = new Node(80, 180);
        Graph.addNode(node3);
        Node node4 = new Node(140, 180);
        Graph.addNode(node4);
        Node node5 = new Node(20, 160);
        Graph.addNode(node5);
        Node node6 = new Node(100, 160);
        Graph.addNode(node6);
        Node node7 = new Node(200, 160);
        Graph.addNode(node7);
        Node node8 = new Node(140, 140);
        Graph.addNode(node8);
        Node node9 = new Node(40, 120);
        Graph.addNode(node9);
        Node node10 = new Node(100, 120);
        Graph.addNode(node10);
        Node node11 = new Node(180, 100);
        Graph.addNode(node11);
        Node node12 = new Node(60, 80);
        Graph.addNode(node12);
        Node node13 = new Node(120, 80);
        Graph.addNode(node13);
        Node node14 = new Node(180, 60);
        Graph.addNode(node14);
        Node node15 = new Node(20, 40);
        Graph.addNode(node15);
        Node node16 = new Node(100, 40);
        Graph.addNode(node16);
        Node node17 = new Node(200, 40);
        Graph.addNode(node17);
        Node node18 = new Node(20, 20);
        Graph.addNode(node18);
        Node node19 = new Node(60, 20);
        Graph.addNode(node19);
        Node node20 = new Node(160, 20);
        Graph.addNode(node20);
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}
