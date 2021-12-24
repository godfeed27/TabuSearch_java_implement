import IO.Input;
import IO.Output;
import algorithms.Greedy;
import algorithms.Tabu;
import dataStructure.Problem;
import dataStructure.Solution;

public class App {
    public static void main(String[] args) throws Exception {
        String[] problemList = {"a280.tsp", "eil51.tsp", "bier127.tsp", "d1291.tsp", "eil101.tsp", "fl1400.tsp", "pcb3038.tsp", "pr2392.tsp", "rl1889.tsp", "u1060.tsp"};
        for (String problemName : problemList) {
            System.out.println("Solving " + problemName);

            Input input = new Input("D:/TabuSearch_java_implement/data/" + problemName);
            Problem problem = new Problem();
            input.setProblem(problem);

            Solution newSolution = new Solution();

            Greedy greedy = new Greedy(problem, 600.0, newSolution);
            newSolution = greedy.solve();
            System.out.println("Greedy");
            System.out.println(newSolution.getTotalDistance(problem));

            Tabu tabu = new Tabu(problem, 600.0, newSolution, 3, 0.3);
            newSolution = tabu.solve();
            System.out.println("\nTabu");
            System.out.println(newSolution.getTotalDistance(problem));

            Output output = new Output("D:/TabuSearch_java_implement/output/");
            output.writeSolution(problem, tabu);
        }
    }
}
