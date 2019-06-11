package design.pattern.decorator;

public abstract class DecoratorAbstractClass implements CommonInterfaceForAll{

	/**
	 * Decorator class declares a composition relationship to the common interface, 
	 * and this data member is initialized in its constructor.
	 */
	private CommonInterfaceForAll coreClass;
	
	DecoratorAbstractClass(CommonInterfaceForAll inner) {
		this.coreClass = inner;
	}
	
	public void doIt() {
		this.coreClass.doIt();
	}
}
