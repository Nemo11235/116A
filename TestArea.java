
public class TestArea {

	public static void main(String[] args) {
		Vec v1 = new Vec(1,3,4);
		Vec v2 = new Vec(3,4,5);
		
		// test crossProduct
		System.out.println("Cross Product: ");
		Vec.print(Vec.crossProduct(v1, v2));
		
		// test normalize
		System.out.println("Normalized: ");
		Vec.normalize(v1);
		Vec.print(v1);
	}
}
