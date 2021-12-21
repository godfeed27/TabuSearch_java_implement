package algorithms;

import dataStructure.Problem;
import dataStructure.Solution;

public class Algorithm {
    Problem problem;
    public double timeLimit;

    public Algorithm(Problem problem, double timeLimit) {
        this.problem = problem;
        this.timeLimit = timeLimit*1000;
    }

    public Solution solve() {
        Solution solution = new Solution();
        return solution;
    }
}
