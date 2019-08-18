package main.service.serviceimpl;

import java.util.ArrayList;

import main.domain.Floor;
import main.domain.ParkingLot;
import main.domain.Slot;
import main.service.IFloorService;

public class FloorServiceImpl implements IFloorService {

	public void addFloor(int floorNo) {
		Floor floor = new Floor();
		floor.setLevel(floorNo);
		ParkingLot.floors.add(floor);
		ParkingLot.slotOnFloor.put(floor, new ArrayList<Slot>());
	}
	
}
