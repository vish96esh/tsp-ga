package com.vishesh.tsp;

public class GA {
	
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;

    // Evolves a population over one generation
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);
        //saving the fittest individual from the population as the first individual
        newPopulation.saveTour(0, pop.getFittest());
        // Crossover population
        for (int i = 1; i < newPopulation.populationSize(); i++) {
            // Select parents
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            // Crossover parents
            Tour child = crossover(parent1, parent2);
            newPopulation.saveTour(i, child);
        }

        // Mutation
        for (int i = 1; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Tour crossover(Tour parent1, Tour parent2) {
        Tour child = new Tour();
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.tourSize(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setNode(i, parent1.getNode(i));
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setNode(i, parent1.getNode(i));
                }
            }
        }

        // Loop through parent2's tour and add missing nodes to child
        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsNode(parent2.getNode(i))) {
                // Loop to find a spastatusre position in the child's tour
                for (int j = 0; j < child.tourSize(); j++) {
                    if (child.getNode(j) == null) {
                        child.setNode(j, parent2.getNode(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap mutation
    private static void mutate(Tour tour) {
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            if(Math.random() < mutationRate){
                int tourPos2 = (int) (tour.tourSize() * Math.random());
                Node node1 = tour.getNode(tourPos1);
                Node node2 = tour.getNode(tourPos2);
                tour.setNode(tourPos2, node1);
                tour.setNode(tourPos1, node2);
            }
        }
    }
    
    //Selection using Tournament Selection
    private static Tour tournamentSelection(Population pop) {
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        Tour fittest = tournament.getFittest();
        return fittest;
    }

}
