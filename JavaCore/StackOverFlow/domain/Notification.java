package domain;

import java.sql.Date;

public class Notification {

	private int notificationId;
	private Date createdOn;
	private String content;
	
	public boolean sendNotification() {return true;};
	
}
