package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import dataStructure.Problem;

public class Output {
	
	Problem problem;
	
	public Output(Problem problem) {
		this.problem = problem;
	}
	
	public void saveDistanceMatrix(String folderPath) throws IOException{

		String outFilePath = folderPath + "\\" + problem.getName() + ".matrix.tsp";
		File outFile = new File(outFilePath);
        outFile.getParentFile().mkdirs();
        FileWriter fileWriter = new FileWriter(outFile);
        
        System.out.println("Writer file: " + outFile.getAbsolutePath());
        for (int i = 0; i < problem.getDistanceMatrix().length; i++) {
        	for (int j = 0; j < problem.getDistanceMatrix()[0].length; j++) {
        		fileWriter.write(String.valueOf(problem.getDistanceMatrix()[i][j]) + " ");
        	}
        	fileWriter.write("\n");
        }
        fileWriter.write("EOF");
        System.out.println("Successfull!");
        fileWriter.close();
	}
	
	
	public void writeSolution(String folderPath) throws IOException{
		String outFileName = folderPath + "\\" + problem.getName() + ".tour.tsp";
		File outFile = new File(outFileName);
        outFile.getParentFile().mkdirs();
        FileWriter fileWriter = new FileWriter(outFile);
        System.out.println("Writer file: " + outFile.getAbsolutePath());
        fileWriter.write("NAME: " + problem.getName() + "\nCOMMENT: " + problem.getComment() + "\nDIMENSION: ");
        fileWriter.write(String.valueOf(problem.getDimension()));
        fileWriter.write("\nDISTANCE: " + String.valueOf(problem.getSolution().getTotalDistance(problem)) + "\nEXECUTION_TIME: " + problem.getExecutionTime() + "\nTOUR_SOLUTION: " + "\n");
        for (int i = 0; i < problem.getSolution().getTour().size(); i++) {
        	fileWriter.write(String.valueOf(problem.getSolution().getTour().get(i) + 1) + " ");
        }
        fileWriter.write("\n");
        fileWriter.write("EOF");
        System.out.println("Successfull!");
        fileWriter.close();
	}
	
}
