package domain;

import java.util.List;

import bookingconstants.BookingStatus;

public class CinemaHall {

	private String name;
	private int totalSeats;
	
	private List<Show> shows;
	private List<CinemaHallSeat> seats;
	
	private Payment payment;
	private BookingStatus status;
}
