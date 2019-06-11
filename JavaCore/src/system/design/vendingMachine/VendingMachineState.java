package system.design.vendingMachine;

public interface VendingMachineState {
	
	public void selctProductAndInsertMoney(int amount, String productName);
	
	public void dispenseProduct();

}
