package service.core;

import java.sql.Date;
import java.util.List;

import domain.Movie;

public interface Search {

	public List<Movie> searchByTitle(String title);
	public List<Movie> searchByLanguage(String title);
	public List<Movie> searchByGenre(String title);
	public List<Movie> searchByReleaseDate(Date title);
	public List<Movie> searchByCity(String title);
	
}
