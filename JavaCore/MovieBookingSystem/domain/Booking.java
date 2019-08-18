package domain;

import java.sql.Date;
import java.util.List;

import bookingconstants.BookingStatus;

public class Booking {

	private String bookingNumber;
	private int NOOfSeats;
	
	private List<ShowSeat> seats;
	private Show show;
	
	private BookingStatus status;
	
	private Date createdOn;
	
	static class  BookingService{
		public boolean applyCoupon(Coupon cpoupon) {return true;};
		public boolean makePayment(Payment payment) {return true;};
		public boolean cancel() {return true;};
		public boolean assignSeats(List<ShowSeat> seats) {return true;};
	}
}
