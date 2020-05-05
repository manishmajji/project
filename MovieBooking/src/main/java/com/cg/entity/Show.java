package com.cg.entity;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="shows")
@DynamicUpdate
@DynamicInsert
public class Show {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="show_id")
	private Integer showId;
	
	
	@Column(name="show_start_time")
	private Time showStartTime;
	
	@Column(name="show_end_time")
	private Time showEndTime;
	
	
	
	@OneToMany(mappedBy="show",cascade=CascadeType.ALL,orphanRemoval=true)
	
	private List<Seat> seats;
	
	@Column(name="show_name")
	private String showName;
	
	@OneToOne
	@JoinColumn(name="movie_id",referencedColumnName="movie_id")
	private Movie movie;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Screen screen;
	
	@Column(name="theatre_id")
	private Integer theatreId;

	public Show() {
		super();
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Time getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(Time showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Time getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(Time showEndTime) {
		this.showEndTime = showEndTime;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Movie getMovieName() {
		return movie;
	}

	public void setMovieName(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreenId() {
		return screen;
	}

	public void setScreenId(Screen screenId) {
		this.screen = screenId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	
	
}