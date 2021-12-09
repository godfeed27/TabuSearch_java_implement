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
}