package com.vishesh.tsp;

public class Node {
	int x;
    int y;
    
    public Node(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given node
    public double distanceTo(Node node){
        int xDistance = Math.abs(getX() - node.getX());
        int yDistance = Math.abs(getY() - node.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}
