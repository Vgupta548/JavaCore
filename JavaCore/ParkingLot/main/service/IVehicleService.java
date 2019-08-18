package main.service;

import main.domain.Slot;
import main.domain.Vehicle;

public interface IVehicleService {

	main.domain.Slot findVehicle(String regString);
	
	void addVehicle(Slot slot, Vehicle vehicle);
	
	void removeVehicle(Vehicle vehicle) ;
}
