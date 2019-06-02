package core;

public class SingletionClass {

	//private instance so that it can only be accessed only by getInstane() method 
	private static volatile SingletionClass instance = null;

	// private constructor
	private SingletionClass() {
		
	}
	
	public static SingletionClass getInstance() {
		if(instance == null) {
			//synchronized block to remove overhead
			synchronized (SingletionClass.class) {
				if(instance == null) {
					// if instance is null, initialize 
					instance = new SingletionClass();
				}
			}
			
		}
		return instance;
	}
	
	//when singleton  class is loaded BillPlugSinleton class not loaded into memory
	// and only when someone calls the getInstance1() method , this class loaded and creates the singleton class instance.
	private static class BillPughSingleton{
		
		// if a field is final, it is part of the JVM specification that it must effectively ensure that,
		// once the object pointer is available to other threads, so are the correct values of that object's final fields.
		private static final SingletionClass INSTANCE = new SingletionClass();
		
	}
	
	private static SingletionClass getInstance1() {
			return BillPughSingleton.INSTANCE;
	}
}
