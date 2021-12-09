package dataStructure;

import java.util.ArrayList;

public class Solution {
    double[][] DistanceMatrix;
    ArrayList<Integer> tour;

    public Solution() {

    }

    public Solution(double[][] DistanceMatrix, ArrayList<Integer> tour) {
        this.setDistanceMatrix(DistanceMatrix);
        this.setTour(tour);
    }

    public ArrayList<Integer> getTour() {
        return tour;
    }

    public void setTour(ArrayList<Integer> tour) {
        this.tour = tour;
    }

    public double[][] getDistanceMatrix() {
        return DistanceMatrix;
    }

    public void setDistanceMatrix(double[][] distanceMatrix) {
        this.DistanceMatrix = distanceMatrix;
    }
}