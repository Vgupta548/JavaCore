package access;

public class Demo {

	public static void main(String[] args) {
		D d = new D();
		d.show();
		
		System.out.println("========");
		
		B b = new D();
		b.show();
		

		System.out.println("========");
		
		A c = new D();
		c.show();
		
		
		System.out.println("========");
		
		B bb = new B();
		bb.show();
		
		System.out.println("========");
		
		A baa = new B();
		baa.show();
	}
}
