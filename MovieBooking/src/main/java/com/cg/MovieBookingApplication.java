package com.cg;



import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.IShowDao;
import com.cg.dao.IUniversalDao;

import com.cg.entity.Seat;
import com.cg.entity.SeatState;
import com.cg.entity.Show;



@SpringBootApplication
public class MovieBookingApplication implements CommandLineRunner {
	
	

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}

	@Autowired
	IShowDao dao;
	
	
	@Autowired
	IUniversalDao<Show> dao4;
	
	
	@Autowired
	IUniversalDao<Seat> dao6;
	@Override
	public void run(String... args) throws Exception {

/*
		//Seat Insertion
		Show s=dao4.findById(4983493);
		List<Seat> seats=new ArrayList<Seat>();
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				Seat seat=new Seat();
				seat.setSeatPrice(100.0);
				seat.setShow(s);
				seat.setSeatStatus(SeatState.AVAILABLE);
				dao6.save(seat);
				seats.add(seat);
				}
		}
		s.setSeats(seats);
		dao4.update(s);
		
	*/	
	}

}





// TODO Auto-generated method stub'
/*
Movie movie=dao.findById(4);
Movie movie2=dao.findById(6);
Movie movie3=dao.findById(7);

Theatre t=dao2.findById(5);

Customer c=dao.getCustomer(3);
System.out.println(c.getUsername());
Set<Movie> movies=t.getListOfMovies();

for (Iterator iterator = t.getListOfMovies().iterator(); iterator.hasNext();) {
	Movie type = (Movie) iterator.next();
	System.out.println(type.getMovieName());;
};

movies.add(movie);
movies.add(movie2);
movies.add(movie3);



t.setListOfMovies(movies);

dao2.update(t);




dao2.update(t);
t=dao2.update(t);

System.out.println(t.getTheatreName());

System.out.println(movie.getDirector());
movie.setDirector("trivikram");
movie.setGenre("drama");
movie.setHero("MB");
movie.setHeroine("Trisha");
movie.setMovieName("Athadu 3");

Theatre t =new Theatre();
t.setManagerContact("6532162");
t.setManagerName("polsani");
t.setTheatreCity("warangal");
t.setTheatreName("Amrutha");

dao.addTheatre(t);

dao.addMovie(movie);














Theatre t=dao2.findById(5);
Show s=new Show();
s.setMovie(dao3.findById(4));
s.setSeats(null);
s.setShowEndTime(Timestamp.valueOf(LocalDateTime.now()));
s.setShowStartTime(Timestamp.valueOf(LocalDateTime.now()));
s.setShowName("Morning show");
s.setTheatreId(t);
dao.save(s);
try
{
List<Show> shows=dao.findActiveShows();
for (Iterator iterator = shows.iterator(); iterator.hasNext();) {
	Show show = (Show) iterator.next();
	System.out.println(show.getShowStartTime().format(DateTimeFormatter.ofPattern("dd-MM-YYYY, EEEE HH:mm:ss")));
}
}
catch(NullPointerException e)
{
	System.out.println("null pointer exceprtion occured");
}
System.out.println("hai sandeep");
}




Seat Insertion
Show s=dao4.findById(8);
List<Seat> seats=new ArrayList<Seat>();
for (int i = 0; i < s1.getHallHeight(); i++) {
	for (int j = 0; j < s1.getHallWidth(); j++) {
		Seat seat=new Seat();
		seat.setSeatPrice(100.0);
		seat.setShow(s);
		seat.setSeatStatus(SeatState.AVAILABLE);
		dao6.save(seat);
		seats.add(seat);
		}
}
s.setSeats(seats);
dao4.update(s);
*/

