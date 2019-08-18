package main.service.serviceimpl;

import main.domain.Car;
import main.domain.ParkingLot;
import main.domain.Slot;
import main.domain.Vehicle;
import main.service.IVehicleService;

public class VehicleServiceImpl implements IVehicleService{

	public Slot findVehicle(String regNo) {
		Slot slot = null;
		
		if(regNo != null && regNo != "") {
			slot = ParkingLot.parkedVehicle.get(new Car(regNo));
		}
		
		return slot;
	}

	@Override
	public void addVehicle(Slot slot, Vehicle vehicle) {
		ParkingLot.parkedVehicle.put(vehicle, slot);
	}
	
	@Override
	public void removeVehicle(Vehicle vehicle) {
		ParkingLot.parkedVehicle.remove(vehicle);
	}
}
