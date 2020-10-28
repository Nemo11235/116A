import java.util.*;

public class TestArea {

	public static void main(String[] args) {

		Vec v1 = new Vec(0.6,0.8,0);
		Vec v2 = new Vec(0,1,0);
//		// test crossProduct
//		System.out.println("Cross Product: ");
//		Vec.print(Vec.crossProduct(v1, v2));
//		
		int choice;
		System.out.println("------------------------------------------------------------\n"
				+ "1. Get normal of a vector\n"
				+ "2. Get cross product of 2 vectors\n"
				+ "3. Get normal by 3 vertex\n"
				+ "4. Get diffuse lighting\n"
				+ "5. Get specular lighting\n"
				+ "");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		while(true) {
			switch(choice) {
			case 1:
				getNorm();
				break;
			case 2:
				crossProduct();
				break;
			case 3:
				normOfTrig();
				break;
			case 4:
				getDiffuse();
				break;
			
			}
			
			System.out.println("------------------------------------------------------------\n"
					+ "1. Get normal of a vector\n"
					+ "2. Get cross product of 2 vectors\n"
					+ "3. Get normal by 3 vertex\n"
					+ "4. Get diffuse lighting\n"
					+ "5. Get specular lighting\n"
					+ "");
			choice = scan.nextInt();
			
		}
	}
	public static void crossProduct() {
		Vec v1 = new Vec();
		Vec v2 = new Vec();
		System.out.print("Cross Product is: ");
		Vec.print(Vec.crossProduct(v1, v2));
	}
	
	public static void getNorm() {
		Vec v = new Vec();
		Vec.normalize(v);
		System.out.print("Norm: ");
		Vec.print(v);
	}
	
	public static void normOfTrig() {
		Vec v0 = new Vec();
		Vec v1 = new Vec();
		Vec v2 = new Vec();
		v0.setVec(v1.x - v0.x, v1.y - v0.y, v1.z - v0.z);
		System.out.print("V1 - V0: ");
		Vec.print(v0);
		v1.setVec(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
		System.out.print("V2 - V1: ");
		Vec.print(v1);
		System.out.print("Normal is: ");
		Vec.print(Vec.crossProduct(v0, v1));
	}
	
	public static void getDiffuse() {
		System.out.println("Position of light: ");
		Vec light = new Vec();
		System.out.println("Vertex: ");
		Vec v = new Vec();
		System.out.println("Normal vector of the surface:");
		Vec N = new Vec();
		System.out.println("Diffuse color of material: ");
		Vec difM = new Vec();
		System.out.println("Diffuse color of light: ");
		Vec difL = new Vec();
		Vec L = new Vec(light.x - v.x, light.y - v.y, light.z - v.z);
		System.out.println("L = " + light.toString() + "-" + "v.toString");
		Vec.normalize(L);
		Vec.normalize(N);
		System.out.println("Normalized L = " + L.toString());
		System.out.println("Normalized N = " + N.toString());
		System.out.println("Diffuse color = N*L * " + difM.toString() + "x" + difL);
		difL.setVec(difL.x * difM.x, difL.y * difM.y, difL.z * difM.z);
		double nl = L.dotProduct(N);
		System.out.println("= " + nl + "*" + difL.toString());
		difL.setVec(nl*difL.x, nl*difL.y, nl*difL.z);
		System.out.println("= " + difL.toString());
		
		
	}
}
