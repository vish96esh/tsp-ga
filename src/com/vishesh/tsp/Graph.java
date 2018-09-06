package com.vishesh.tsp;

import java.util.ArrayList;

public class Graph {
	private static ArrayList<Node> nodes = new ArrayList<Node>();

    public static void addNode(Node node) {
        nodes.add(node);
    }
    
    public static Node getNode(int index){
        return (Node)nodes.get(index);
    }
    
    public static int numberOfNodes(){
        return nodes.size();
    }
}
