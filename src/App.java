import IO.Input;
import algorithms.Greedy;
import algorithms.Tabu;
import dataStructure.Problem;

public class App {
    public static void main(String[] args) throws Exception {
        Input input = new Input("D:/TabuSearch_java_implement/src/data/a280.tsp");
        Problem problem = new Problem();
        input.setProblem(problem);
        Greedy greedy = new Greedy(problem, 600);
        problem.setSolution(greedy.solve());
        // Tabu tabu = new Tabu(problem, 600);
        // problem.setSolution(tabu.solve());
        System.out.println(problem.getTotalDistance());
    }
}
