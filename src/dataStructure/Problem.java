package dataStructure;

public class Problem {
	
	String name;
	String type;
	int dimension;
	double[][] distanceMatrix;
	Solution solution = new Solution();
	
	public Problem() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public double[][] getDistanceMatrix() {
		return distanceMatrix;
	}

	public void setDistanceMatrix(double[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}

	public void printDistanceMatrix() {
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				System.out.print(this.distanceMatrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public Solution getSolution() {
		return this.solution;
	}
	
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

}
