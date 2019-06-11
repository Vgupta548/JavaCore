package system.design.vendingMachine_logic.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import system.design.vendingMachine_logic.domain.Coin;
import system.design.vendingMachine_logic.domain.Product;
import system.design.vendingMachine_logic.exceptions.NoProductSelected;
import system.design.vendingMachine_logic.exceptions.NotFullPaidException;
import system.design.vendingMachine_logic.exceptions.NotSufficientChangeException;
import system.design.vendingMachine_logic.exceptions.ProductAlreadySelectedException;
import system.design.vendingMachine_logic.exceptions.SoldOutException;
import system.design.vendingMachine_logic.models.Inventory;
import system.design.vendingMachine_logic.service.VendingMachine;
import system.design.vendingMachine_logic.util.Pair;

public class VendingMachineImpl implements VendingMachine {

	private Inventory<Coin> coinInventory = new Inventory<Coin>();
	private Inventory<Product> productInventory = new Inventory<Product>();

	private int totalSales = 0;
	private Product currentProduct;
	private int currentBalance;

	public VendingMachineImpl() {
		initialCoinInventory();
	}

	/**
	 * Initialize inventory with 5 each type of coin and 5 item of each product
	 */
	private void initialCoinInventory() {
		for (Coin coin : Coin.values()) {
			coinInventory.put(coin, 5);
		}

		for (Product product : Product.values()) {
			productInventory.put(product, 5);
		}
	}

	@Override
	public long selectProductAndGetPrice(Product product) {
		if(currentProduct != null) {
			throw new ProductAlreadySelectedException("Another transaction is in Progress. Please try later");
		}
		if (productInventory.hasItem(product)) {
			currentProduct = product;
			int price = product.getPrice();
			return price;
		} else {
			throw new SoldOutException(product + " has been sold out. Please by Another Item");
		}

	}

	@Override
	public void insertCoin(Coin coin) {
		currentBalance = currentBalance + coin.getDenomination();
		coinInventory.add(coin);
	}

	@Override
	public List<Coin> refund() {
		List<Coin> refund = getChange(currentBalance);
		updateCoinInventory(refund);
		currentBalance = 0;
		currentProduct = null;
		return refund;
	}

	@Override
	public Pair<Product, List<Coin>> collectProductAndChange() {
		if(currentProduct == null) {
			throw new NoProductSelected("No Product is Selected, Please select a product First.");
		}
		// collect item
		Product product = collectProduct();

		// total price
		totalSales = totalSales + currentProduct.getPrice();

		// collect change
		List<Coin> changes = collectChange();

		return new Pair<Product, List<Coin>>(product, changes); 
	}

	@Override
	public void reset() {
		coinInventory.clear();
		productInventory.clear();
		currentBalance = 0;
		currentProduct = null;
		totalSales = 0;
	}

	private Product collectProduct() {
		if (isFullPaid()) {
			if (hasSufficientChange()) {
				if (productInventory.hasItem(currentProduct)) {
					productInventory.deduct(currentProduct);
					return currentProduct;
				}
			} else {
				throw new NotSufficientChangeException("Not Sufficient Change in inventry.");
			}
		}

		long remainingBalance = currentProduct.getPrice() - currentBalance;
		throw new NotFullPaidException("Price not fully paid, remaining :" + remainingBalance);
	}

	private boolean isFullPaid() {
		return currentBalance >= currentProduct.getPrice() ? true : false;
	}

	private boolean hasSufficientChange() {
		int remainingBalance = (int) (currentBalance - currentProduct.getPrice());
		try {
			getChange(remainingBalance);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	private List<Coin> collectChange(){
		int changeAmount = currentBalance - currentProduct.getPrice(); 
		List<Coin> changes = getChange(changeAmount);
		updateCoinInventory(changes);
		currentBalance = 0;
		currentProduct = null;
		return changes;
	}
	
	private void updateCoinInventory(List<Coin> changes) {
		for(Coin c : changes) {
			coinInventory.deduct(c);
		}
	}

	private List<Coin> getChange(int amount) {
		List<Coin> changes = Collections.EMPTY_LIST;
		if (amount > 0) {
			changes = new ArrayList<Coin>();
			int balance = amount;
			while (balance > 0) {
				if (balance >= Coin.QUARTER.getDenomination() && coinInventory.hasItem(Coin.QUARTER)) {
					changes.add(Coin.QUARTER);
					balance = balance - Coin.QUARTER.getDenomination();
				} else if (balance >= Coin.DIME.getDenomination() && coinInventory.hasItem(Coin.DIME)) {
					changes.add(Coin.DIME);
					balance = balance - Coin.DIME.getDenomination();
				} else if (balance >= Coin.NICKEL.getDenomination() && coinInventory.hasItem(Coin.NICKEL)) {
					changes.add(Coin.NICKEL);
					balance = balance - Coin.NICKEL.getDenomination();
				} else if (balance >= Coin.PENNY.getDenomination() && coinInventory.hasItem(Coin.PENNY)) {
					changes.add(Coin.PENNY);
					balance = balance - Coin.PENNY.getDenomination();
				} else {
					throw new NotSufficientChangeException("Not Sufficient Change, Please try another Product.");
				}
			}
		}

		return changes;
	}

}
