package algorithms;

import dataStructure.Problem;
import dataStructure.Solution;

public class Algorithm {
    Problem problem;
    long TimeLimit;

    public Algorithm(Problem problem, long TimeLimit) {
        this.problem = problem;
        this.TimeLimit = TimeLimit;
    }

    public Solution solve() {
        Solution solution = new Solution();
        return solution;
    }
}
