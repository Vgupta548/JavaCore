package design.pattern.decorator;

public class DecoratorDerivedClassY extends DecoratorAbstractClass{

	 DecoratorDerivedClassY(CommonInterfaceForAll inner) {
		 super(inner);
	}

	 public void doY() {
		 System.out.println("functionality of y");
	 }
	 
	 public void doIt() {
		 super.doIt();
		 doY();
	 }
}
