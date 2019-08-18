package service;

import domain.Movie;
import domain.Show;
import domain.users.Person;

public class Admin extends Person{

	class AdminService{
		public boolean addMovie(Movie movie) {return true;}
		public boolean removeMovie(Movie movie) {return true;}
		public boolean addShow(Show show) {return true;}
		public boolean removeShow(Show show) {return true;}
		public boolean blockUser(Customer customer) {return true;}
		public boolean unBlockuser(Customer customer) {return true;}
	}
}
