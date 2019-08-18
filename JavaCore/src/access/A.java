package access;

public class A {
	
	public int x =1;
	public int y =2;
	public int z =3;
	
	public void show() {
		System.out.println("in A");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		abc();
	}

	public void abc() {
		System.out.println("in A");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}
