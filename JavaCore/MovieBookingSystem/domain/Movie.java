package domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import domain.users.Admin;

public class Movie {

	private String name;
	private String description;
	private int durationTime;
	private String languague;
	private Date releaseDate;
	private String country;
	private String genre;
	private Admin movieAddedBy;
	private List<Show> shows;
	
	static class MovieService{
		public List<Show> getShows(){return new ArrayList<Show>();};
	}
}
