package design.pattern.decorator;

public class DecoratorDerivedClassZ extends DecoratorAbstractClass{

	
	DecoratorDerivedClassZ(CommonInterfaceForAll inner) {
		 super(inner);
	}

	 public void doZ() {
		 System.out.println("functionality of z");
	 }
	 
	 public void doIt() {
		 super.doIt();
		 doZ();
	 }

}
