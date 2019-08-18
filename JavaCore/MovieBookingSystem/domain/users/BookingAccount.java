package domain.users;

import Constants.AccountStatus;

public class BookingAccount {
	private int id;
	private String password;
	private AccountStatus accountStatus;
	
	 class AccountService{
		 public boolean resetPassword() {return true;};
	 }
}


