package system.design.vendingMachine_logic.domain;

public enum Product {

	Coke("coke", 25), Pepei("pepsi", 25), Soda("soda", 25);
	
	private String name;
	private int price;
	
	private Product(String name, int money) {
		this.name = name;
		this.price = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
