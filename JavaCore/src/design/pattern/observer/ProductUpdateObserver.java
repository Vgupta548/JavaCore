package design.pattern.observer;

public abstract class ProductUpdateObserver {
	
	/**
	 * 
	 * Observers register themselves with the Subject
	 * @param productService
	 *
	 */
	protected ProductService subject;
	
	/**
	 * Observers "pull" the information they need from the Subject
	 * @param pId
	 * @param key
	 * @param value
	 */
	public abstract void updateProduct(int pId, String key, Object value);

}
