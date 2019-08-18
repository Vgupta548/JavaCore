package core;

public class Overlading {

	public static void main(String[] args) {
		print(1.0);
		print(1);
		//print(null);

	
	
	
	}
	
	public static void print(String i) {
		System.out.println("String");
	}
	
	public static void print(Integer i) {
		System.out.println("Integer");
	}
	
public static void print(int i) {
	System.out.println("int");
	}

public static void print(float i) {
	System.out.println("float");
}

public static void print(double i) {
	System.out.println("double");
}

public static void print(Double i) {
	System.out.println("Double");
}

public static void print(Object i) {
	System.out.println("object");
}
	
}
