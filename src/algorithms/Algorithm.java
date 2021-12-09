package algorithms;

import dataStructure.Solution;

public class Algorithm {
    Solution Solution;
    long TimeLimit;

    public Algorithm(Solution Solution, long TimeLimit) {
        this.Solution = Solution;
        this.TimeLimit = TimeLimit;
    }

    public Solution solve() {   
        return this.Solution;
    }
}
