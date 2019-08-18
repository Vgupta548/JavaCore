package domain;

import java.sql.Date;
import java.util.List;

import domain.users.Member;

public class Answer {

	private String answerText;
	private boolean accepted;
	private int voteCount;
	private int flagCount;
	private Date creationTime;
	
	private Member creatingMember;
	private List<Photo> photos;
	
	public boolean incrementVoteCount() {return true;};
}
