package system.design.vendingMachine;

public class HasMoneyState implements VendingMachineState {

	public HasMoneyState() {
	}

	@Override
	public void selctProductAndInsertMoney(int amount, String productName) {
		System.out.println("Already Vending machine has money and product selcted, so wait till it finses the current dispnse product" );
	}

	@Override
	public void dispenseProduct() {
		System.out.println(" Vending machine dispenses the products" );

	}

}
