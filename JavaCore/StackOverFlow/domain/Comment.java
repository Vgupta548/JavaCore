package domain;

import java.sql.Date;

import domain.users.Member;

public class Comment {

	private String answerText;
	private int voteCount;
	private int flagCount;
	private Date creationTime;
	
	private Member askingMember;
	
	public boolean incrementVoteCount() {return true;};
}
