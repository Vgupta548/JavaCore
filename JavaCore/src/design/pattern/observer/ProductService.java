package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

	/**
	 *  The Subject is coupled only to the Observer base class
	 */
	List<ProductUpdateObserver> observers = new ArrayList<ProductUpdateObserver>();

	/**
	 * Subject is an object having methods to attach and detach observers to a
	 * client object
	 * 
	 * @param productUpdateObserver
	 */
	public void addObserver(ProductUpdateObserver productUpdateObserver) {
		this.observers.add(productUpdateObserver);
	}

	public void updateProduct(int pId, String key, Object value) {
		System.out.println("Updating Product in Database");
		ntifyAllObservers(pId, key, value);
	}

	/**
	 * The Subject broadcasts events to all registered Observers
	 * 
	 * @param pId
	 * @param key
	 * @param value
	 */
	public void ntifyAllObservers(int pId, String key, Object value) {

		for (ProductUpdateObserver observer : observers) {
			observer.updateProduct(pId, key, value);
		}
	}
}
