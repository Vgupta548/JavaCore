package design.pattern.observer;

public class ProductUpdateElasticObserver extends ProductUpdateObserver{
	
	/**
	 * Observers register themselves with the Subject
	 * @param productService
	 */
	ProductUpdateElasticObserver(ProductService productService){
		this.subject = productService;
		this.subject.addObserver(this);
	}

	public void updateProduct(int pId, String key, Object value) {
		System.out.println("updating product in Elastic ");
	}
}
