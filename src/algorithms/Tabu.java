package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import dataStructure.Problem;
import dataStructure.Solution;

public class Tabu extends Algorithm {
    int neighborSize;
    double tabusSize;
    Queue<Integer> tabus = new LinkedList<>();

    Random rand = new Random();

    public Tabu(Problem problem, double timeLimit, Solution solution, int neighborSize, double tabusSize) {
        super(problem, timeLimit, solution);
        this.name = "tabu";
        this.neighborSize = neighborSize;
        this.tabusSize = tabusSize;
        this.tabus = tabus;
    }

    public ArrayList<int[]> createNeighborList() {
        ArrayList<int[]> neighborList = new ArrayList<int[]>();
        for (int i = 0; i < this.problem.getDimension() * this.neighborSize; i++) {
            neighborList.add(new int[2]);
            for (int j = 0; j < 2; j++) {
                neighborList.get(i)[j] = rand.nextInt(this.problem.getDimension());
            }
        }
        return neighborList;
    }

    public double distanceVariesTwoOpt(int[] neighbor, Solution solution) {
        double totalChange;
        double totalDistanceBefore = 0;
        double totalDistanceAfter = 0;
        int maxIdx = Math.max(neighbor[0], neighbor[1]);
        int minIdx = Math.min(neighbor[0], neighbor[1]);
        int maxVertice = solution.getTour().get(maxIdx);
        int minVertice = solution.getTour().get(minIdx);
        int nextVertice = 0;
        int previousVertice = 0;

        if (minIdx == maxIdx) {
            totalChange = 0;
        } else if (minIdx == 0 && maxIdx + 1 == solution.getTour().size()) {
            totalChange = 0;
        } else if (minIdx == 0 && maxIdx + 2 == solution.getTour().size()) {
            totalChange = 0;
        } else if (maxIdx + 1 == solution.getTour().size()) {
            nextVertice = solution.getTour().get(0);
            previousVertice = solution.getTour().get(minIdx - 1);
        } else if (minIdx == 0) {
            nextVertice = solution.getTour().get(maxIdx + 1);
            previousVertice = solution.getTour().get(solution.getTour().size() - 1);
        } else {
            nextVertice = solution.getTour().get(maxIdx + 1);
            previousVertice = solution.getTour().get(minIdx - 1);
        }

        totalDistanceBefore = this.problem.getDistanceMatrix()[previousVertice][minVertice] + this.problem.getDistanceMatrix()[nextVertice][maxVertice];
        totalDistanceAfter = this.problem.getDistanceMatrix()[previousVertice][maxVertice] + this.problem.getDistanceMatrix()[nextVertice][minVertice];

        totalChange = totalDistanceBefore - totalDistanceAfter;

        return totalChange;
    }

    public void swapNeighbor(ArrayList<int[]> neighborList, int neighbor1, int neighbor2) {
        int[] temp = neighborList.get(neighbor1).clone();
        neighborList.set(neighbor1, neighborList.get(neighbor2).clone());
        neighborList.set(neighbor2, temp);
    }

    public void neighborListSort(ArrayList<int[]> neighborList, Solution solution) {
        for (int i = 0; i < neighborList.size()-1; i++) {
            for (int j = i+1; j < neighborList.size(); j++) {
                if (this.distanceVariesTwoOpt(neighborList.get(i), solution) < this.distanceVariesTwoOpt(neighborList.get(j), solution)) {
                    this.swapNeighbor(neighborList, i, j);
                }
            }
        }
    }

    public Solution swapTwoEdges(int[] neighbor, Solution solution) {
        Solution newSolution = solution;
        int maxIdx = Math.max(neighbor[0], neighbor[1]);
        int minIdx = Math.min(neighbor[0], neighbor[1]);
        ArrayList<Integer> newTour = newSolution.getTour();
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
        newSolution.setTour(newTour);
        return newSolution;
    }

    public boolean checkTabus(int[] neighbor) {
        return this.tabus.contains(neighbor[0]) && this.tabus.contains(neighbor[1]);
    }

    public void updateTabus(int[] neighbor) {
        if (!this.tabus.contains(neighbor[0])) {
            this.tabus.add(neighbor[0]);
        }
        if (!this.tabus.contains(neighbor[1])) {
            this.tabus.add(neighbor[1]);
        }
        while (this.tabus.size() > this.problem.getDimension() * this.tabusSize) {
            tabus.remove();
        }
    }

    public Solution localSearch(Solution solution,double timeLimit) {
        Solution newSolution = solution;
        double timeStart = System.currentTimeMillis();
        while (true) {
            ArrayList<int[]> neighborList = this.createNeighborList();
            for (int[] neighbor : neighborList) {
                if (this.distanceVariesTwoOpt(neighbor, newSolution) > 0) {
                    newSolution = this.swapTwoEdges(neighbor, newSolution);
                    // System.out.println(newSolution.getTotalDistance(problem));
                }
            }
            double timeCheck = System.currentTimeMillis();
            if (timeCheck - timeStart >= timeLimit) {
                break;
            }
        }
        return newSolution;
    }

    @Override
    public Solution solve() {
        problem.setComment("Tabu Search - tabusSize: " + this.tabusSize + " - neighborSize: " + this.neighborSize);

        double timeStart = System.currentTimeMillis();

        Solution currentSolution = new Solution();
        Solution bestSolution = new Solution();
        currentSolution = this.solution.copy();
        bestSolution = this.solution.copy();

        System.out.println("current");
        System.out.println(currentSolution.getTotalDistance(problem));
        System.out.println("best");
        System.out.println(bestSolution.getTotalDistance(problem));

        int[] neighbor = new int[2];
        double distanceVariesChange = 0;
        ArrayList<Solution> goodSolutionList = new ArrayList<>();
        
        while (true) {
            ArrayList<int[]> neighborList = this.createNeighborList();

            // neighborList.sort((neighbor1, neighbor2) -> {return (int) this.distanceVariesTwoOpt(neighbor1, currentSolution) - (int) this.distanceVariesTwoOpt(neighbor2, currentSolution);});
            this.neighborListSort(neighborList, currentSolution);

            for (int i = 0; i < neighborList.size(); i++) {
                neighbor = neighborList.get(i);
                distanceVariesChange = this.distanceVariesTwoOpt(neighbor, currentSolution);

                // System.out.println("change");
                // System.out.println(distanceVariesChange);
                // System.out.println("old current");
                // System.out.println(currentSolution.getTotalDistance(problem));
                
                if (distanceVariesChange >= 0) {
                    currentSolution = this.swapTwoEdges(neighbor, currentSolution);
                    if (currentSolution.getTotalDistance(this.problem) <= bestSolution.getTotalDistance(this.problem)) {
                        bestSolution = currentSolution.copy();
                        this.updateTabus(neighbor);
                        break;
                    }
                    else {
                        this.updateTabus(neighbor);
                        break;
                    }
                }
                else if (!checkTabus(neighbor)) {
                    currentSolution = this.swapTwoEdges(neighbor, currentSolution);
                    this.updateTabus(neighbor);
                    break;
                }
                currentSolution = this.swapTwoEdges(neighbor, currentSolution);
                this.updateTabus(neighbor);
            }
            if (!goodSolutionList.contains(bestSolution)) {
                goodSolutionList.add(bestSolution);
            }

            // System.out.println("current");
            // System.out.println(currentSolution.getTotalDistance(problem));
            // System.out.println("best");
            // System.out.println(bestSolution.getTotalDistance(problem));

            double timeCheck = System.currentTimeMillis();
            if (timeCheck - timeStart >= 0.75*this.timeLimit) {
                break;
            }
        }

        for (int i = 0; i < goodSolutionList.size(); i++) {
            goodSolutionList.set(i, this.localSearch(goodSolutionList.get(i), 0.25*timeLimit/goodSolutionList.size()));
        }

        for (int i = 0; i < goodSolutionList.size(); i++) {
            if (goodSolutionList.get(i).getTotalDistance(problem) < bestSolution.getTotalDistance(problem)) {
                bestSolution = goodSolutionList.get(i);
            }
        }

        // System.out.println(goodSolutionList.size());

        double timeOut = System.currentTimeMillis();
        this.setExecutionTime((timeOut - timeStart)/1000);;
        this.solution = bestSolution;
        return this.solution;
    }
}
