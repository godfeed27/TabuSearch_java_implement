package algorithms;

import java.util.ArrayList;
import java.util.Random;

import dataStructure.Problem;
import dataStructure.Solution;

public class Tabu extends Algorithm {
    int neighborSize;
    double tabusSize;

    Random rand = new Random();

    public Tabu(Problem problem, long timeLimit, int neighborSize, double tabusSize) {
        super(problem, timeLimit);
        this.neighborSize = neighborSize;
        this.tabusSize = tabusSize;
    }

    public int[][] createNeighborList() {
        int[][] neighborList = new int[this.problem.getDimension() * this.neighborSize][2];
        for (int i = 0; i < this.problem.getDimension() * this.neighborSize; i++) {
            for (int j = 0; j < 2; j++) {
                neighborList[i][j] = rand.nextInt(this.problem.getDimension());
            }
        }
        return neighborList;
    }

    public double distanceVariesTwoOpt(int[] neighbor) {
        double totalChange;
        double totalDistanceBefore = 0;
        double totalDistanceAfter = 0;
        int maxIdx = Math.max(neighbor[0], neighbor[1]);
        int minIdx = Math.min(neighbor[0], neighbor[1]);
        int maxVertice = this.problem.getSolution().getTour().get(maxIdx);
        int minVertice = this.problem.getSolution().getTour().get(minIdx);
        int nextVertice = 0;
        int previousVertice = 0;

        if (minIdx == maxIdx) {
            totalChange = 0;
        } else if (minIdx == 0 && maxIdx + 1 == this.problem.getSolution().getTour().size()) {
            totalChange = 0;
        } else if (minIdx == 0 && maxIdx + 2 == this.problem.getSolution().getTour().size()) {
            totalChange = 0;
        } else if (maxIdx + 1 == this.problem.getSolution().getTour().size()) {
            nextVertice = this.problem.getSolution().getTour().get(0);
            previousVertice = this.problem.getSolution().getTour().get(minIdx - 1);
        } else {
            nextVertice = this.problem.getSolution().getTour().get(maxIdx + 1);
            previousVertice = this.problem.getSolution().getTour().get(minIdx - 1);
        }

        totalDistanceBefore += this.problem.getDistanceMatrix()[previousVertice][minVertice];
        totalDistanceBefore += this.problem.getDistanceMatrix()[nextVertice][maxVertice];
        totalDistanceAfter += this.problem.getDistanceMatrix()[previousVertice][maxVertice];
        totalDistanceAfter += this.problem.getDistanceMatrix()[nextVertice][minVertice];

        totalChange = totalDistanceBefore - totalDistanceAfter;

        return totalChange;
    }

    public ArrayList<Integer> swapTwoEdges(int[] neighbor) {
        int maxIdx = Math.max(neighbor[0], neighbor[1]);
        int minIdx = Math.min(neighbor[0], neighbor[1]);
        ArrayList<Integer> newTour = this.problem.getSolution().getTour();
        ArrayList<Integer> first = new ArrayList();
        ArrayList<Integer> second = new ArrayList();
        ArrayList<Integer> third = new ArrayList();
        for (int i = 0; i < minIdx; i++) {
            first.add(newTour.get(i));
        }
        for (int i = maxIdx; i > minIdx - 1; i--) {
            second.add(newTour.get(i));
        }
        for (int i = maxIdx + 1; i < newTour.size(); i++) {
            third.add(newTour.get(i));
        }
        newTour.clear();
        newTour.addAll(first);
        newTour.addAll(second);
        newTour.addAll(third);
        return newTour;
    }

    @Override
    public Solution solve() {
        Solution solution = new Solution();
        return solution;
    }
}
