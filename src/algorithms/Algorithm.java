package algorithms;

import dataStructure.Problem;
import dataStructure.Solution;

public class Algorithm {
    Problem problem;
    double timeLimit;
    Solution solution = new Solution();
    double executionTime;

    public Algorithm(Problem problem, double timeLimit, Solution solution) {
        this.problem = problem;
        this.timeLimit = timeLimit*1000;
        this.solution = solution;
        this.executionTime = executionTime;
    }

    public Solution getSolution() {
        return this.solution;
    }

    public double getExecutionTime() {
        return this.executionTime;
    }

    public void setExecutionTime(double executionTime) {
        this.executionTime = executionTime;
    }

    public Solution solve() {
        Solution solution = new Solution();
        return solution;
    }
}
