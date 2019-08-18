package domain.users;

import java.util.List;

import domain.Badge;
import domain.Question;
import domain.Tag;
import domain.users.BookingAccount;

public class Member {
	
	private BookingAccount account;
	private List<Badge> badges;
	
	public boolean createQuestion(Question question){return true;};
	public boolean createTag(Tag tag) {return true;};
	public String getEmail() { return " ";};
	public int getReputation(){return 1;};

}
