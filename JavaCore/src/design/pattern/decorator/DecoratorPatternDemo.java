package design.pattern.decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		
		CommonInterfaceForAll[] arr = {
				new DecoratorDerivedClassX(new CoreClass()),
				new DecoratorDerivedClassY(new CoreClass()),
				new DecoratorDerivedClassZ(new CoreClass()),
				
				new DecoratorDerivedClassY(new DecoratorDerivedClassX(new CoreClass())),
				new DecoratorDerivedClassZ(new DecoratorDerivedClassX(new CoreClass())),
				new DecoratorDerivedClassZ(new DecoratorDerivedClassY(new CoreClass())),
				
				new DecoratorDerivedClassZ(new DecoratorDerivedClassY(new DecoratorDerivedClassX(new CoreClass())))
		};
		
		for(CommonInterfaceForAll asArr : arr) {
			asArr.doIt();
			System.out.println("---");
		}
	}

}


