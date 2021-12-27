import IO.Input;
import IO.Output;
import algorithms.Greedy;
import algorithms.Tabu;
import dataStructure.Problem;
import dataStructure.Solution;

public class App {
    public static void main(String[] args) throws Exception {
        String[] problemList = {"a280", "eil51", "bier127", "d1291", "eil101", "fl1400", "pcb3038", "pr2392", "rl1889", "u1060"};
        for (String problemName : problemList) {
            System.out.println("Solving " + problemName);

            Input input = new Input("data/" + problemName + ".tsp");
            Problem problem = new Problem();
            input.setProblem(problem);

            Solution newSolution = new Solution();

            Greedy greedy = new Greedy(problem, 600.0, newSolution);
            newSolution = greedy.solve();
            System.out.println("Greedy");
            System.out.println(newSolution.getTotalDistance(problem));

            Tabu tabu = new Tabu(problem, 1.0, newSolution, 3, 0.3);
            newSolution = tabu.solve();
            System.out.println("\nTabu");
            System.out.println(newSolution.getTotalDistance(problem));

            Output output = new Output("output/");
            output.writeSolution(problem, tabu);
        }
    }
}
