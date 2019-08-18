package service.core;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import domain.Movie;

public class Catalog implements Search {

	HashMap<String, List<Movie>> movieTitles;
	HashMap<String, List<Movie>> movieLanguage;
	HashMap<String, List<Movie>> movieGenres;
	HashMap<Date, List<Movie>> movieReleaseDates;
	HashMap<String, List<Movie>> cityName;
	
	@Override
	public List<Movie> searchByTitle(String title) {
		return movieTitles.get(title);
	}

	@Override
	public List<Movie> searchByLanguage(String language) {
		return movieLanguage.get(language);
	}

	@Override
	public List<Movie> searchByGenre(String genre) {
		return movieGenres.get(genre);
	}

	@Override
	public List<Movie> searchByReleaseDate(Date releaseDate) {
		return movieReleaseDates.get(releaseDate);
	}

	@Override
	public List<Movie> searchByCity(String city) {
		return cityName.get(city);
	}

}
