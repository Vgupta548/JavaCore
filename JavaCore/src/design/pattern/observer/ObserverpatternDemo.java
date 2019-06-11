package design.pattern.observer;

/**
 * Behavioural Design Pattern
 * 
 * Observer design pattern is used when
 * there is one-to-many relationship between
 * objects such that if one objects is modified,
 * its dependent objects are to be notified automatically
 * 
 * Observer pattern uses three actor classes. Subject, Observer and Client. 
 * 
 * @author Vipin Gupta
 *
 */
public class ObserverpatternDemo {
	
	public static void main(String[] args) {
		ProductService subject = new ProductService();
		
		
		/**
		 * Client configures the number and type of Observers
		 */
		new ProductUpdateElasticObserver(subject);
		new ProductUpdateRedisObserver(subject);
		
		System.out.println("First change price: 15000");	
	      subject.updateProduct(12312, "price", 15000);
	      System.out.println("Second state change: 10");	
	      subject.updateProduct(12312, "wireless charging", "No");
	   }
		
	}

