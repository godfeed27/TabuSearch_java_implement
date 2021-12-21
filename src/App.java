import IO.Input;
import IO.Output;
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
        System.out.println(problem.getSolution().getTotalDistance(problem));
        Tabu tabu = new Tabu(problem, 600.0, 3, 0.3);
        problem.setSolution(tabu.solve());
        // System.out.println(problem.getSolution().getTour());
        System.out.println(problem.getSolution().getTotalDistance(problem));
        Output output = new Output(problem);
        output.writeSolution("D:/TabuSearch_java_implement/output");
    }
}
