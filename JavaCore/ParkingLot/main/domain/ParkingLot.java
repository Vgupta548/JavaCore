package main.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
	
	public static Address address;
	public static List<Floor> floors = new ArrayList<Floor>();
	public static List<Slot> slots = new ArrayList<Slot>();
	public static Map<Floor, List<Slot>>  slotOnFloor =new HashMap<Floor, List<Slot>>();
	public static List<EntryGate> entryGates = new ArrayList<EntryGate>();
	public static List<ExitGate> exitGates = new ArrayList<ExitGate>();
	
	public static Map<Vehicle, Slot> parkedVehicle = new HashMap<Vehicle, Slot>();
	
}

