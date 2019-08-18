package domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Constants.QuestionClosingRemark;
import Constants.QuestionStatus;
import domain.users.Member;

public class Question {

	private String title;
	private String description;
	private Date creationTime;
	private Date updationTime;
	private QuestionStatus status;
	private int voteCount;
	private int viewCount;
	private QuestionClosingRemark closingremark;
	
	private Member askingmember;
	private Bounty bounty;
	private List<Photo> photos;
	
	private List<Answer> answers;
	private List<Comment> comments;
	
	
	public boolean close() {return true;};
	public boolean undelete() {return true;};
	public boolean addComment(Comment comment) {return true;};
	public boolean addBounty(Bounty bounty) {return true;};
	
	public static List<Question> search(String query){
		return new ArrayList<Question>();
	}
	
}
