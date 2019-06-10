package design.pattern.observer;

public class ProductUpdateRedisObserver extends ProductUpdateObserver{

	/**
	 * Observers register themselves with the Subject
	 * @param productService
	 */
	ProductUpdateRedisObserver(ProductService productService){
		this.subject = productService;
		this.subject.addObserver(this);
	}
	
	public void updateProduct(int pId, String key, Object value) {
		System.out.println("updating product in redis ");
	}

}
