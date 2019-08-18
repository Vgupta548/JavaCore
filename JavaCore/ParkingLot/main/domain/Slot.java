package main.domain;

import java.util.Map;

import main.constants.Slot_satus;

public class Slot {

	private int slotNo;
	private Map<EntryGate, Integer> distanceFromMap;
	private Floor floor;
	private Vehicle vehicle;
	private Slot_satus status;
	
	public Slot(){
		
	}
	
	public Slot(Floor floor, int slotNo) {
		this.floor = floor;
		this.slotNo = slotNo;
		this.status = Slot_satus.AVAILABLE;
	}
	
	public Slot(Floor floor, int slotNo, Slot_satus slot_satus) {
		this.floor = floor;
		this.slotNo = slotNo;
		this.status = slot_satus;
	}
	
	public int getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}
	public Map<EntryGate, Integer> getDistanceFromMap() {
		return distanceFromMap;
	}
	public void setDistanceFromMap(Map<EntryGate, Integer> distanceFromMap) {
		this.distanceFromMap = distanceFromMap;
	}
	public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Slot_satus getStatus() {
		return status;
	}
	public void setStatus(Slot_satus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + slotNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (slotNo != other.slotNo)
			return false;
		return true;
	}
	
	
	
	
	
}
