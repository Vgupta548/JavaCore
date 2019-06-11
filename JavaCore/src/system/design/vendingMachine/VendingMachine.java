package system.design.vendingMachine;

public class VendingMachine implements VendingMachineState{
	
	private VendingMachineState vendingMachineState;

	public VendingMachine() {
		vendingMachineState = new NoMoneyState();
	}
	
	public VendingMachineState getVendingMachineState() {
		return vendingMachineState;
	}

	public void setVendingMachineState(VendingMachineState vendingMachineState) {
		this.vendingMachineState = vendingMachineState;
	}

	@Override
	public void selctProductAndInsertMoney(int amount, String productName) {
		vendingMachineState.selctProductAndInsertMoney(amount, productName);
		
		if(vendingMachineState instanceof NoMoneyState) {
			VendingMachineState hasMoneyState = new HasMoneyState();
			setVendingMachineState(hasMoneyState);
			System.out.println("VM state has been changes to : "+getVendingMachineState());
		}
		
	}

	@Override
	public void dispenseProduct() {
			vendingMachineState.dispenseProduct();
		
		if(vendingMachineState instanceof HasMoneyState) {
			VendingMachineState noMachineState = new NoMoneyState();
			setVendingMachineState(noMachineState);
			System.out.println("VM state has been changes to : "+getVendingMachineState());
		}
		
	}
	
	

}
