package system.design.vendingMachine;

public class NoMoneyState implements VendingMachineState {

	public NoMoneyState() {
	}

	@Override
	public void selctProductAndInsertMoney(int amount, String productName) {
			System.out.println(amount+" Rs has been instered "+productName +" is selected");
	}

	@Override
	public void dispenseProduct() {
		System.out.println("Vending machine can not dispense the product because money is not insterted and product is not selected");
	}

}
