package core;

public class SingaltionClass {

	//private instance so that it can only be accessed only by getInstane() method 
	private static SingaltionClass instance = null;

	// private constructor
	private SingaltionClass() {
	}
	
	public static SingaltionClass getInstance() {
		if(instance == null) {
			//synchronized block to remove overhead
			synchronized (SingaltionClass.class) {
				if(instance == null) {
					// if instance is null, initialize 
					instance = new SingaltionClass();
				}
			}
			
		}
		return instance;
	}
	
	//when singalton  class is loaded BillPlugSinleton class not loaded into memory
	// and only when someone calls the getInstance1() method , this class loaded and creates the singleton class instance.
	private static class BillPughSingleton{
		private static final SingaltionClass INSTANCE = new SingaltionClass();
		
	}
	
	private static SingaltionClass getInstance1() {
			return BillPughSingleton.INSTANCE;
	}
}
