package system.design.vendingMachine_logic.util;

public class Pair<T, E> {

	T v1;
	E v2;
	
	public Pair(T t, E e) {
		this.v1 = t;
		this.v2 = e;
	}
	
	public T v1() {
		return v1;
	}
	
	public E v2() {
		return v2;
	}

}
