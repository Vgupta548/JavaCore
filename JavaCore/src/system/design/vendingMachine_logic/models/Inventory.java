package system.design.vendingMachine_logic.models;

import java.util.HashMap;
import java.util.Map;

/**
 * And adapter over Map to create Inventory to hold cash and Items inside
 * Vending Machine
 * 
 * @author vipingupta
 *
 */
public class Inventory<T> {

	private Map<T, Integer> inventory = new HashMap();

	public void addInventory(T item) {
		inventory.putIfAbsent(item, 0);
	}

	public int getInventory(T item) {
		return inventory.getOrDefault(item, 0);
	}

	public void put(T item, int quantity) {
		inventory.put(item, inventory.get(item) + quantity);
	}

	public boolean hasItem(T item) {
		return getInventory(item) > 0;
	}

	public void add(T item) {
		if (hasItem(item)) {
			inventory.put(item, inventory.get(item) + 1);
		}
	}
	
	public void deduct(T item) {
		if (hasItem(item)) {
			inventory.put(item, inventory.get(item) - 1);
		}
	}
	
	public void clear() {
		inventory.clear();
	}

}
