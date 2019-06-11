package system.design.vendingMachine_logic.service;

import java.util.List;

import system.design.vendingMachine_logic.domain.Coin;
import system.design.vendingMachine_logic.domain.Product;
import system.design.vendingMachine_logic.util.Pair;

public interface VendingMachine {
	
	public long selectProductAndGetPrice(Product product);
	
	public void insertCoin(Coin coin);
	
	public List<Coin> refund();
	
	public Pair<Product, List<Coin>> collectProductAndChange();
	
	public void reset();

}
