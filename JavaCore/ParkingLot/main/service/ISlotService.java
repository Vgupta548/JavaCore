package main.service;

import java.util.List;

import main.constants.Slot_satus;
import main.domain.Floor;
import main.domain.Slot;
import main.domain.Vehicle;

public interface ISlotService {
	
	void addSlot(Floor floor, int slotNo);

	Slot findEmptySlot();
	
	Slot allocateVehicle(Slot slot, Vehicle vehicle);
	
	void vacateSlot(Slot slot);
	
	 Slot findSlot(int slotNo, int floorNo);
	
	List<Slot> fetchSlots(Slot_satus slotStatus);
}
