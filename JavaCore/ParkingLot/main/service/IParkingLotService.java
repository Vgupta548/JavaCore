package main.service;

import java.util.List;

import main.constants.COLOR;
import main.constants.Slot_satus;
import main.domain.ParkingLot;
import main.domain.Slot;

public interface IParkingLotService {

	void createParlingLot(int floors, int slots);
	
	Slot ParkVehicle(String regNo, COLOR color);
	
	Slot vacateSlot(int slotNo, int floorNo);
	
	Slot findVehicle(String regNo, COLOR Color);
	
	List<Slot> getSlotByStatus(Slot_satus status);
	
	void addEntryGate(ParkingLot parkingLot);
	
	void addExitGate(ParkingLot parkingLot);
	
}
