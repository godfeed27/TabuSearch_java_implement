package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import algorithms.Algorithm;
import dataStructure.Problem;

public class Output {
	
	String folderPath;
	
	public Output(String folderPath) {
		this.folderPath = folderPath;
	}
	
	public void saveDistanceMatrix(Problem problem) throws IOException{

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
	
	
	public void writeSolution(Problem problem, Algorithm algorithm) throws IOException{
		String outFileName = folderPath + problem.getName() + "." + algorithm.getName() + ".tour";
		File outFile = new File(outFileName);
        outFile.getParentFile().mkdirs();
        FileWriter fileWriter = new FileWriter(outFile);
        System.out.println("Writer file: " + outFile.getAbsolutePath());
        fileWriter.write("NAME: " + problem.getName() + "\nCOMMENT: " + problem.getComment() + "\nDIMENSION: ");
        fileWriter.write(String.valueOf(problem.getDimension()));
        fileWriter.write("\nDISTANCE: " + String.valueOf(algorithm.getSolution().getTotalDistance(problem)) + "\nEXECUTION_TIME: " + algorithm.getExecutionTime() + "\nTOUR_SECTION: " + "\n");
        for (int i = 0; i < algorithm.getSolution().getTour().size(); i++) {
        	fileWriter.write(String.valueOf(algorithm.getSolution().getTour().get(i) + 1) + " ");
        }
        fileWriter.write("\n");
        fileWriter.write("EOF");
        System.out.println("Successfull!");
        fileWriter.close();
	}
	
}
