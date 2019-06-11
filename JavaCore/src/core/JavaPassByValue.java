package core;


public class JavaPassByValue {

	public static void main(String[] args) {
		TestClass s = new TestClass(1, "ABC");
		System.out.println("1 "+s.hashCode());
		s.aaa = "aaaaa";
		System.out.println("s1 "+s.aaa);
		update(s);
		System.out.println("s33 "+s.aaa);
		System.out.println("33"+s.hashCode());
		System.out.println(s.toString());
		
		System.out.println("======");
		
		TestClass s2 = new TestClass(1, "ABC");
		System.out.println("1 "+s2.hashCode());
		s2.aaa = "aaaaa";
		System.out.println("s1 "+s2.aaa);
		update(s2);
		System.out.println("s33 "+s2.aaa);
		System.out.println("33"+s2.hashCode());
		System.out.println(s2.toString());

	}
	
	static void update(TestClass s) {
		System.out.println("2 "+s.hashCode());
		System.out.println("s2 "+s.aaa);
		//s = new Student(2, "XYZ");
		s.aaa = "xyz";
		System.out.println("3 : "+s.hashCode());
		System.out.println("s3 "+s.aaa);
	}
	
	static void update2(TestClass s) {
		System.out.println("2 "+s.hashCode());
		System.out.println("s2 "+s.aaa);
		s = new TestClass(2, "XYZ");
		s.aaa = "xyz";
		System.out.println("3 : "+s.hashCode());
		System.out.println("s3 "+s.aaa);
	}

}


class TestClass {
	private int id;
	private String name;
	public String aaa = ""; 
	public TestClass(int id, String name) { 
		this.id = id; this.name = name; 
	}
	
	public String toString() {
		return "id :"+id;
	}
	// getters, settters, toString
}
