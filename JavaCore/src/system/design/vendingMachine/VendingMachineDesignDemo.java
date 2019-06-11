package system.design.vendingMachine;

public class VendingMachineDesignDemo {

	public VendingMachineDesignDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		vm.dispenseProduct();
		vm.selctProductAndInsertMoney(30, "pepsi");
		
		vm.dispenseProduct();
		vm.dispenseProduct();
		
		vm.selctProductAndInsertMoney(40, "cockaola");
		vm.selctProductAndInsertMoney(50, "amul");
		vm.dispenseProduct();
	}

}
