// Course: CS116 A

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
				+ "6. Get Ray tracing\n"
				+ "7. Get Ray-Triangle Intersection.\n"
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
			case 5:
				getSpecular();
				break;
			case 7:
				getRayTriangle();
				break;
			
			}
			
			System.out.println("------------------------------------------------------------\n"
					+ "1. Get normal of a vector\n"
					+ "2. Get cross product of 2 vectors (normal of the triangle) (ambient color)\n"
					+ "3. Get normal by 3 vertex\n"
					+ "4. Get diffuse lighting (diffuse color)\n"
					+ "5. Get specular lighting (specular color) \n"
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
		System.out.println("L = " + light.toString() + "-" + v.toString());
		Vec.normalize(L);
		Vec.normalize(N);
		System.out.println("Normalized L = " + L.toString());
		System.out.println("Normalized N = " + N.toString());
		System.out.println("Diffuse color = N.L * " + difM.toString() + "x" + difL);
		difL.setVec(difL.x * difM.x, difL.y * difM.y, difL.z * difM.z);
		double nl = L.dotProduct(N);
		System.out.println("= " + nl + "*" + difL.toString());
		difL.setVec(nl*difL.x, nl*difL.y, nl*difL.z);
		System.out.println("= " + difL.toString());	
	}
	
	public static void getSpecular() {
		System.out.println("the viewer is at position: ");
		Vec viewer = new Vec();
		System.out.println("Vertex(V0 V1 or V2...): ");
		Vec v = new Vec();
		Vec V = new Vec(viewer.x - v.x, viewer.y - v.y, viewer.z - v.z);
		System.out.println("Normal vector of the surface:");
		Vec N = new Vec();
		Vec.normalize(N);
		
		//from light -- diffuse part
		System.out.println("Position of light: ");
		Vec L = new Vec();
		Vec.normalize(L);
		
		System.out.println("Specular color of light: ");
		Vec speL = new Vec();
		System.out.println("Specular color of material: ");
		Vec speM = new Vec();
			
		System.out.println("V = " + viewer.toString() + "-" + v.toString());
		Vec.normalize(V); 
		System.out.println("Normalized V: " + V.toString());
		Vec H = new Vec(V.x + L.x, V.y + L.y, V.z + L.z);

		System.out.println("H = L + V = " + H.toString());
		Vec.normalize(H);
		System.out.println("Normalized H: " + H.toString());
		
		System.out.println("Specular color = N.H * " + speL.toString() + "x" + speM.toString());
		speL.setVec(speL.x * speM.x, speL.y * speM.y, speL.z * speM.z);
		double n2 = N.dotProduct(H);
		System.out.println("= " + n2 + "*" + speL.toString());
		speL.setVec(n2*speL.x, n2*speL.y, n2*speL.z);
		System.out.println("= " + speL.toString());	
	}
	
	//Question 4 for get Ray-Triangle
	public static void getRayTriangle()
	{
		System.out.println("Enter P0 vector: ");
		Vec v0 = new Vec();
		System.out.println("Enter P1 vector: ");
		Vec v1 = new Vec();
		System.out.println("Enter P2 vector: ");
		Vec v2 = new Vec();
		
		System.out.println("Camera position: "); // D = Pixel(R) - Camera(P)
		Vec camP = new Vec();
		System.out.println("Pixel position: "); // D = Pixel(R) - Camera(P)
		Vec pixR = new Vec();
		Vec D = new Vec(pixR.x - camP.x, pixR.y - camP.y, pixR.z - camP.z);
		
		Vec e0 = new Vec(v1.x - v0.x, v1.y - v0.y, v1.z - v0.z);
		Vec e1 = new Vec(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
		Vec e2 = new Vec(v0.x - v2.x, v0.y - v2.y, v0.z - v2.z);
	   
		System.out.println("e0 = " + v1.toString() + " - " + v0.toString() + " = " + e0.toString());
		System.out.println("e1 = " + v2.toString() + " - " + v1.toString() + " = " + e1.toString());
		Vec n = new Vec(0, 0, 0);
		n = Vec.crossProduct(e0, e1);
		System.out.println("n = e0 X e1 = " + n.toString());
		double k = v2.dotProduct(n);
		System.out.println("k =" + v2.toString() + "." + n.toString() + " = " + k);
		double t = (k - camP.dotProduct(n))/D.dotProduct(n);
		System.out.println("t = (" + k + "-" + camP.toString() + "." + n.toString() + ")/(" + D.toString() + "." + n.toString() + ") = " + t);
		
		Vec R = new Vec(camP.x + t * D.x, camP.y + t * D.y, camP.z + t * D.z);
		System.out.println("Intersection point with plan, R = " + camP.toString() + " + " + t + "*" + D + " = " + R.toString());
		
		Vec p0 = new Vec(R.x - v0.x, R.y - v0.y, R.z - v0.z);//p0 = R – P​0​
		Vec p1 = new Vec(R.x - v1.x, R.y - v1.y, R.z - v1.z);//p1 = R - P1
		Vec p2 = new Vec(R.x - v2.x, R.y - v2.y, R.z - v2.z);//p2 = R - P2
		Vec A1 = new Vec(0,0,0);
		A1 = Vec.crossProduct(e0, p0);
		Vec B1 = new Vec(0,0,0);
		B1 = Vec.crossProduct(e1, p1);
		Vec C1 = new Vec(0,0,0);
		C1 = Vec.crossProduct(e2, p2);
		//condition for whether intersection point is inside the triangle.
		double A = A1.dotProduct(n);
		double B = B1.dotProduct(n);
		double C = C1.dotProduct(n);
		
		if(A > 0 && B > 0 && C > 0)
		{
			System.out.println("(e0 x (R – P0)).n = (" + e0.toString() + " x (" + p0.toString() + ")." + n.toString() + " = " + A + "> 0");
			System.out.println("(e1 x (R – P1)).n = (" + e1.toString() + " x (" + p1.toString() + ")." + n.toString() + " = " + B + "> 0");
			System.out.println("(e2 x (R – P2)).n = (" + e2.toString() + " x (" + p2.toString() + ")." + n.toString() + " = " + C + "> 0");
			
			System.out.println("Intersection point is inside of the triangle. Therefore, ray was intersect triangle A.");
		} else if (A < 0) {
			System.out.println("(e0 x (R – P0)).n = (" + e0.toString() + " x (" + p0.toString() + ")." + n.toString() + " = " + A + "< 0");
			System.out.println("(e1 x (R – P1)).n = (" + e1.toString() + " x (" + p1.toString() + ")." + n.toString() + " = " + B + "> 0");
			System.out.println("(e2 x (R – P2)).n = (" + e2.toString() + " x (" + p2.toString() + ")." + n.toString() + " = " + C + "> 0");
			
			System.out.println("Intersection point is outside of the triangle. Therefore, ray does not intersect triangle A.");
		} else if (B < 0) {
			System.out.println("(e0 x (R – P0)).n = (" + e0.toString() + " x (" + p0.toString() + ")." + n.toString() + " = " + A + "> 0");
			System.out.println("(e1 x (R – P1)).n = (" + e1.toString() + " x (" + p1.toString() + ")." + n.toString() + " = " + B + "< 0");
			System.out.println("(e2 x (R – P2)).n = (" + e2.toString() + " x (" + p2.toString() + ")." + n.toString() + " = " + C + "> 0");
			
			System.out.println("Intersection point is outside of the triangle. Therefore, ray does not intersect triangle A.");
		} else if (C < 0) {
			System.out.println("(e0 x (R – P0)).n = (" + e0.toString() + " x (" + p0.toString() + ")." + n.toString() + " = " + A + "> 0");
			System.out.println("(e1 x (R – P1)).n = (" + e1.toString() + " x (" + p1.toString() + ")." + n.toString() + " = " + B + "> 0");
			System.out.println("(e2 x (R – P2)).n = (" + e2.toString() + " x (" + p2.toString() + ")." + n.toString() + " = " + C + "< 0");
			
			System.out.println("Intersection point is outside of the triangle. Therefore, ray does not intersect triangle A.");
		}
	}
	
}

