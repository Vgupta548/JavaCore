package domain;

import java.sql.Date;

import bookingconstants.PaymentStatus;

public class Payment {

	private int paymentId;
	private double amount;
	private Date createdOn; 
	
	private int txnId;
	private PaymentStatus status;
	
}
