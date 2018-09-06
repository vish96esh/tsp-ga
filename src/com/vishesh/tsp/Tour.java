package com.vishesh.tsp;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
	private ArrayList<Node> tour = new ArrayList<Node>();
    private double fitness = 0;
    private int distance = 0;
    
    public Tour(){
        for (int i = 0; i < Graph.numberOfNodes(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList<Node> tour){
        this.tour = tour;
    }

    public void generateIndividual() {
        for (int i = 0; i < Graph.numberOfNodes(); i++) {
          setNode(i, Graph.getNode(i));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    public Node getNode(int tourPosition) {
        return (Node)tour.get(tourPosition);
    }
    
    public void setNode(int tourPosition, Node node) {
        tour.set(tourPosition, node);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            for (int i=0; i < tourSize(); i++) {
                Node fromNode = getNode(i);
                Node destinationNode;
                // Check we're not on our tour's last node, if we are set our
                // tour's final destination node to our starting node
                if(i+1 < tourSize())
                    destinationNode = getNode(i+1);
                else
                    destinationNode = getNode(0);
                tourDistance += fromNode.distanceTo(destinationNode);
            }
            distance = tourDistance;
        }
        return distance;
    }

    public int tourSize() {
        return tour.size();
    }
    
    public boolean containsNode(Node node){
        return tour.contains(node);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getNode(i)+"|";
        }
        return geneString;
    }
}
