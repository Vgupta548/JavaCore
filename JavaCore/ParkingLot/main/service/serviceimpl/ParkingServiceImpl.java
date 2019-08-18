package main.service.serviceimpl;

import java.util.List;

import main.constants.COLOR;
import main.constants.Slot_satus;
import main.domain.Car;
import main.domain.Floor;
import main.domain.ParkingLot;
import main.domain.Slot;
import main.domain.Vehicle;
import main.service.IParkingLotService;
import main.service.ISlotService;
import main.service.IVehicleService;

public class ParkingServiceImpl implements IParkingLotService{
	
	ISlotService slotService = new SlotServiceImpl();
	IVehicleService vehicleService = new VehicleServiceImpl();

	public void createParlingLot(int floorNo, int slots) {
		Floor floor = new Floor();
		floor.setLevel(floorNo);
		
		for(int i =0; i<slots; i++) {
			slotService.addSlot(floor, i+1);
		}
	}
	
	public Slot ParkVehicle(String regNo, COLOR color) {
		Vehicle vehicle = new Car(regNo, color);
		
		Slot slot = slotService.findEmptySlot();
		if(slot !=null) {
			slotService.allocateVehicle(slot, vehicle);
		}
		return slot;
	}
	
	public Slot vacateSlot(int slotNo, int floorNo) {
		Slot slot = slotService.findSlot(slotNo, floorNo);
		if(slot != null) {
			slotService.vacateSlot(slot);
		}
		return slot;
	}
	
	@Override
	public Slot findVehicle(String regNo, COLOR Color) {
		return vehicleService.findVehicle(regNo);
	}
	
	@Override
	public List<Slot> getSlotByStatus(Slot_satus status) {
		return slotService.fetchSlots(status);
	}

	@Override
	public void addEntryGate(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExitGate(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		
	}

	
}
