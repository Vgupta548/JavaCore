package main.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import main.constants.Slot_satus;
import main.domain.EntryGate;
import main.domain.Floor;
import main.domain.ParkingLot;
import main.domain.Slot;
import main.domain.Vehicle;
import main.service.IFloorService;
import main.service.ISlotService;
import main.service.IVehicleService;

public class SlotServiceImpl implements ISlotService{

	IFloorService floorService = new FloorServiceImpl();
	IVehicleService vehicleService  = new VehicleServiceImpl();
	
	public void addSlot(Floor floor, int slotNo) {
		Slot slot = new Slot(floor, slotNo, Slot_satus.AVAILABLE);
		
		if(!ParkingLot.slotOnFloor.containsKey(floor)) {
			floorService.addFloor(floor.getLevel());
		}
		ParkingLot.slotOnFloor.get(floor).add(slot);
	}
	
	public Slot findEmptySlot() {
		Slot slot = null;
	
		for(Entry<Floor, List<Slot>>  entry : ParkingLot.slotOnFloor.entrySet()) {
			
			if(entry.getValue() != null && !entry.getValue().isEmpty()) {
				Optional<Slot> avaOptionalSlot = entry.getValue().stream()
						.filter(s -> { return s.getStatus() == Slot_satus.AVAILABLE;})
						.findFirst();
				if(avaOptionalSlot.isPresent()) return avaOptionalSlot.get();
			}
		}
		
		return slot;
	}
	
	public Slot allocateVehicle(Slot slot, Vehicle vehicle) {
		slot.setStatus(Slot_satus.FULL);
		slot.setVehicle(vehicle);
		vehicleService.addVehicle(slot, vehicle);
		return null;
	}
	
	public void vacateSlot(Slot slot) {
		slot.setVehicle(null);
		slot.setStatus(Slot_satus.AVAILABLE);
		vehicleService.removeVehicle(slot.getVehicle());
	}
	
	public Slot findSlot(int slotNo, int floorNo){
		Slot slot = null;
		
		for(Entry<Floor, List<Slot>>  entry : ParkingLot.slotOnFloor.entrySet()) {
			
			if(entry.getValue() != null && !entry.getValue().isEmpty()) {
				Optional<Slot> avaOptionalSlot = entry.getValue().stream().filter(s -> { return s.getSlotNo() == slotNo && s.getFloor().getLevel() == floorNo;}).findFirst();
				if(avaOptionalSlot.isPresent()) return avaOptionalSlot.get();
			}
		}
		
		return slot;
	}
	
	public Slot findEmptySlot(EntryGate entryGate) {
		return null;
	}
	
	
	public List<Slot> fetchSlots(Slot_satus slotStatus){
		List<Slot> slot = new ArrayList<Slot>();
		
		for(Entry<Floor, List<Slot>>  entry : ParkingLot.slotOnFloor.entrySet()) {
			
			if(entry.getValue() != null && !entry.getValue().isEmpty()) {
				slot.addAll(entry.getValue()
						.stream()
						.filter(s -> { return s.getStatus() == slotStatus;})
						.collect(Collectors.toList()));
			}
		}
		
		return slot;
	}
}
