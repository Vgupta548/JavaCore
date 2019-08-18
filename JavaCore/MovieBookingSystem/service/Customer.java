package service;

import java.util.ArrayList;
import java.util.List;

import domain.Booking;

public class Customer {

	class customerService{
		public boolean makeBooking(Booking booking) {return true;};
		public List<Booking> getBooking(){return new ArrayList<Booking>();};
	}
	
}
