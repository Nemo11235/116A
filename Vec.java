import java.lang.*;
import java.util.*;

public class Vec {

	public double x, y, z;
	Scanner scan = new Scanner(System.in);
	
	// default constructor that will asks user input for a new vector
	public Vec() {
		System.out.print("x: ");
		x = scan.nextDouble();
		System.out.print("y: ");
		y = scan.nextDouble();
		System.out.print("z: ");
		z = scan.nextDouble();
	}
	
	// constructor
	public Vec(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// this function resets the values of a vector
	public void setVec(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// return the vector as a string
	public String toString() 
	{	return "(" + x + ", " + y + ", " + z + ")";	}
	
	// this function calculates cross product of 2 vectors and return the result as a new vector.
	public static Vec crossProduct(Vec v1, Vec v2) {
		Vec result = new Vec(0, 0, 0);
		result.x = v1.y * v2.z - v1.z * v2.y;
		result.y = -(v1.x * v2.z - v1.z * v2.x);
		result.z = v1.x * v2.y - v1.y * v2.x;
		return result;
	}
	
	// dot product of 2 vectors
	public Double dotProduct(Vec v2) 
	{	return x * v2.x + y * v2.y + z * v2.z;	}
	
	
	// this function normalize a vector.
	public static void normalize(Vec v) {
		double length = Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.y, 2) + Math.pow(v.z, 2));
		v.x = v.x / length;
		v.y = v.y / length;
		v.z = v.z / length;
	}
	
	// this function prints a vector.
	public static void print(Vec v)
	{	System.out.println("(" + v.x + ", " + v.y + ", " + v.z + ")");	}
}
