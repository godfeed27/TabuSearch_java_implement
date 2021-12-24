package algorithms;

import java.util.ArrayList;

import dataStructure.Solution;
import dataStructure.Problem;

public class Greedy extends Algorithm {
    public Greedy(Problem problem, double timeLimit, Solution solution) {
        super(problem, timeLimit, solution);
        this.name = "greedy";
    }

    public int FindNextVertice(int currentVertice, ArrayList<Integer> candidateVerticeList) {
        double minDistance = Double.POSITIVE_INFINITY;
        int nextVertice = -1;
        for (int vertice : candidateVerticeList) {
            if (this.problem.getDistanceMatrix()[currentVertice][vertice] < minDistance) {
                minDistance = this.problem.getDistanceMatrix()[currentVertice][vertice];
                nextVertice = vertice;
            }
        }
        return nextVertice;
    }
    
    @Override
    public Solution solve() {

        double timeStart = System.currentTimeMillis();

        ArrayList<Integer> candidateVerticeList = new ArrayList<Integer>();
        for (int i = 0; i < problem.getDimension(); i++) {
            candidateVerticeList.add(i);
        }
        int CurrentVertice = 0;
        while (candidateVerticeList.size() > 0) {
            int NextVertice = FindNextVertice(CurrentVertice, candidateVerticeList);
            this.solution.getTour().add(NextVertice);
            candidateVerticeList.remove(candidateVerticeList.indexOf(NextVertice));
            CurrentVertice = NextVertice;
        }

        double timeOut = System.currentTimeMillis();
        this.setExecutionTime((timeOut - timeStart)/1000);;

        return this.solution;
    }
}
