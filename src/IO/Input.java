package IO;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import dataStructure.Problem;
import dataStructure.Vertice;

import java.util.ArrayList;

public class Input {
	
	String filePath;

	public Input(String filePath) {
		this.filePath = filePath;
	}
	
	public void setProblem(Problem problem) throws FileNotFoundException {
		
		FileInputStream fileInputStream = new FileInputStream(this.filePath);
		Scanner fileScanner = new Scanner(fileInputStream);
		
		ArrayList<Vertice> verticeList = new ArrayList<>();
		String currentLine = fileScanner.nextLine();
		while (currentLine.equals("EOF") == false) {
			String[] elements = currentLine.split(":");
			switch (elements[0].trim()) {
			case "NAME":
				problem.setName(elements[1].trim());
				break;
			case "TYPE":
				problem.setType(elements[1].trim());
				break;
			case "DIMENSION":
				problem.setDimension(Integer.parseInt(elements[1].trim()));
			}
			
			if (elements[0].trim().equals("NODE_COORD_SECTION")) {
				for (int i = 0; i < problem.getDimension(); i++) {
					Vertice vertice = new Vertice(fileScanner.nextInt() - 1, fileScanner.nextDouble(), fileScanner.nextDouble());
					verticeList.add(vertice);
					currentLine = fileScanner.nextLine();
				}
			}
			currentLine = fileScanner.nextLine();
		}
		fileScanner.close();
		
		// Set Distance matrix
		problem.setDistanceMatrix(new double[problem.getDimension()][problem.getDimension()]);
		for (Vertice vertice1 : verticeList) {
			for (Vertice vertice2 : verticeList) {
				problem.getDistanceMatrix()[vertice1.getId()][vertice2.getId()] = vertice1.getDistance(vertice2);
			}
		}
	}
}
