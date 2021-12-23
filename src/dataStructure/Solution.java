package dataStructure;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> tour = new ArrayList<Integer>();

    public Solution() {

    }

    public Solution(ArrayList<Integer> tour) {
        this.setTour(tour);
    }

    public ArrayList<Integer> getTour() {
        return tour;
    }

    public void setTour(ArrayList<Integer> tour) {
        this.tour = tour;
    }

    public double getTotalDistance(Problem problem) {
        double totalDistance = 0;
        for (int i = 0; i < this.getTour().size() - 1; i++) {
            totalDistance += problem.getDistanceMatrix()[this.getTour().get(i)][this.getTour().get(i+1)];
        }
        totalDistance += problem.getDistanceMatrix()[this.getTour().get(this.getTour().size() - 1)][this.getTour().get(0)];
        return totalDistance;
    }

    public Solution copy() {
        Solution newSolution = new Solution();
        newSolution.setTour((ArrayList<Integer>) this.tour.clone());
        return newSolution;
    }

}