import java.lang.*;

public class Vec {

	public double x, y, z;
	
	// constructor
	public Vec(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// this function resets the values of a vector
	public void setVec(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// this function calculates cross product of 2 vectors and return the result as a new vector.
	public static Vec crossProduct(Vec v1, Vec v2) {
		Vec result = new Vec(0, 0, 0);
		result.x = v1.y * v2.z - v1.z * v2.y;
		result.y = -(v1.x * v2.z - v1.z * v2.x);
		result.z = v1.x * v2.y - v1.y * v2.x;
		return result;
	}
	
	
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
