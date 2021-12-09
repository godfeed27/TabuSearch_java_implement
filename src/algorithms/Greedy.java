package algorithms;

import java.util.ArrayList;

import dataStructure.Solution;

public class Greedy extends Algorithm {
    public Greedy(Solution Solution, long TimeLimit) {
        super(Solution, TimeLimit);
    }

    public int FindNextVertice(int CurrentVertice, ArrayList<Integer> CandidateVerticeList) {
        double MinDistance = Double.POSITIVE_INFINITY;
        int NextVertice = -1;
        for (int Vertice : CandidateVerticeList) {
            if (this.Solution.getDistanceMatrix()[CurrentVertice][Vertice] < MinDistance) {
                MinDistance = this.Solution.getDistanceMatrix()[CurrentVertice][Vertice];
                NextVertice = Vertice;
            }
        }
        return NextVertice;
    }
    
    @Override
    public Solution solve() {
        this.Solution.setTour(new ArrayList<Integer>());
        ArrayList<Integer> CandidateVerticeList = new ArrayList<Integer>();
        int CurrentVertice = 0;
        while (CandidateVerticeList.size() > 0) {
            int NextVertice = FindNextVertice(CurrentVertice, CandidateVerticeList);
            this.Solution.getTour().add(NextVertice);
            CandidateVerticeList.remove(CandidateVerticeList.indexOf(NextVertice));
            CurrentVertice = NextVertice;
        }
        return this.Solution;
    }
}
