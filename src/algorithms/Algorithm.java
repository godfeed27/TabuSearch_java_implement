package algorithms;

import dataStructure.Problem;
import dataStructure.Solution;

public class Algorithm {
    Problem problem;
    public double timeLimit = 600.0;

    public Algorithm(Problem problem, double TimeLimit) {
        this.problem = problem;
        this.timeLimit = timeLimit*1000;
    }

    public Solution solve() {
        Solution solution = new Solution();
        return solution;
    }
}
