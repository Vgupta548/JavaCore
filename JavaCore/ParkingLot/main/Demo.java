package main;

import java.util.List;

import main.constants.COLOR;
import main.constants.Slot_satus;
import main.domain.Slot;
import main.service.IFloorService;
import main.service.IParkingLotService;
import main.service.ISlotService;
import main.service.IVehicleService;
import main.service.serviceimpl.FloorServiceImpl;
import main.service.serviceimpl.ParkingServiceImpl;
import main.service.serviceimpl.SlotServiceImpl;
import main.service.serviceimpl.VehicleServiceImpl;

public class Demo {

	public static IParkingLotService parkingLotService = new ParkingServiceImpl();
	public static ISlotService slotService = new SlotServiceImpl();
	public static IVehicleService vehicleService = new VehicleServiceImpl();
	public static IFloorService floorService = new FloorServiceImpl();
	
	public static final int defaultFloor = 0;
	
	public static void main(String[] args) {
		createParkingSlot(6);
		
		parkVehicle("KA-01-HH-1234", COLOR.WHITE);
		parkVehicle("KA-01-HH-9999", COLOR.WHITE);
		parkVehicle("KA-01-BB-0001", COLOR.BLACK);
		parkVehicle("KA-01-HH-7777", COLOR.RED);
		parkVehicle("KA-01-HH-2701", COLOR.BLUE);
		parkVehicle("KA-01-HH-3141", COLOR.BLACK);
		
		vacantSlot(4);
		
		statusAllocated();
		
		statusFree();
		
		parkVehicle("KA-01-P-333", COLOR.WHITE);
		parkVehicle("DL-12-AA-9999", COLOR.WHITE);
		
	}
	
	public static void createParkingSlot( int slots) {
		try {
			parkingLotService.createParlingLot(defaultFloor, slots);
			System.out.println("Created a parking lot with "+slots+" slots");
		}catch (Exception e) {
			System.out.println("Some Exception Occured while creating Parking Lot");
		}
	}
	
	public static void parkVehicle(String regNo, COLOR color) {
		try {
			Slot slot  = parkingLotService.ParkVehicle(regNo, color);
			if(slot == null) {
				System.out.println("Sorry, parking lot is full");
			}else {
				System.out.println("Allocated slot number "+ slot.getSlotNo());
			}
		}catch (Exception e) {
			System.out.println("Some Exception Occured while parking Vehicle :reg no-"+regNo+" color-"+color);
		}
	}
	
	public static void vacantSlot(int slotNo) {
		try {
			Slot slot = parkingLotService.vacateSlot(slotNo, defaultFloor);
			if(slot != null) {
				System.out.println("Slot number " +slot.getSlotNo() +" is freed");
			}else {
				System.out.println("Slot number not exist");
			}
		}catch (Exception e) {
			System.out.println("Some Exception Occured while vacent Vehicle :slot no-"+slotNo);
		}
	}
	
	public static void statusAllocated() {
		try {
			List<Slot> allocatedSlots =  parkingLotService.getSlotByStatus(Slot_satus.FULL);
			if(allocatedSlots != null && !allocatedSlots.isEmpty()) {
				System.out.println("Slot no \t Registration \t\t Color");
				for (Slot slot : allocatedSlots) {
					System.out.println(slot.getSlotNo()+"\t\t"+slot.getVehicle().getRegNo()+"\t\t"+slot.getVehicle().getColour());
				}
			}else {
				System.out.println("No Slot is Allocated");
			}
		}catch (Exception e) {
			System.out.println("Some Exception Occured while fetching allocated slots");
		}
	}
	
	public static void statusFree() {
		try {
			List<Slot> allocatedSlots =  parkingLotService.getSlotByStatus(Slot_satus.AVAILABLE);
			if(allocatedSlots != null && !allocatedSlots.isEmpty()) {
				System.out.println("Slots");
				for (Slot slot : allocatedSlots) {
					System.out.println(slot.getSlotNo());
				}
			}else {
				System.out.println("No Slot is Free");
			}
		}catch (Exception e) {
			System.out.println("Some Exception Occured while fetching free slots");
		}
	}
}
