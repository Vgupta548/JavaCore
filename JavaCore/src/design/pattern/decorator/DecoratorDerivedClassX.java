package design.pattern.decorator;

public class DecoratorDerivedClassX extends DecoratorAbstractClass{

	 DecoratorDerivedClassX(CommonInterfaceForAll  inner) {
		 super(inner);
	}
	 
	 private void doX() {
		 System.out.println("functionality of x");
	 }
	 
	 public void doIt() {
		 super.doIt();
		 doX();
	 }

}
