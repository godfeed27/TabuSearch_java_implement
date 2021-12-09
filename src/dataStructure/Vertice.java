package dataStructure;
import java.lang.Math;

public class Vertice {
	
	int id;
	double x;
	double y;

	public Vertice (int id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y; 
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getDistance(Vertice A) {
		return Math.sqrt(Math.pow(x - A.getX(), 2) + Math.pow((y - A.getY()), 2));
	}

	@Override
	public String toString() {
		return "Vertice [id=" + id + ", x=" + x + ", y=" + y + "]";
	}

}
