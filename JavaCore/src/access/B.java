package access;

public class B extends A{

	public int x =11;
	public int y =21;
	//public int z =31;
	
	public void show() {
		System.out.println("in B");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		abc();
	}

	public void abc() {
		System.out.println("in B");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}
}
