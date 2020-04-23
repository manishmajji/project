package com.cg.entity;
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
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="screens")
public class Screen {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="screen_id")
	private Integer screenId;
	
//	@Column(name="theatre_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Theatre theatre;
	
	@Column(name="screen_name")
	private String screenName;
	
	@Column(name="hall_width")
	private int hallWidth;
	
	@Column(name="hall_height")
	private int hallHeight;

	
	@OneToMany(mappedBy="screen",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Show> show;

	
	
	
	public Screen() {
		super();
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public Theatre getTheatreId() {
		return theatre;
	}

	public void setTheatreId(Theatre theatreId) {
		this.theatre = theatreId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getHallWidth() {
		return hallWidth;
	}

	public void setHallWidth(int hallWidth) {
		this.hallWidth = hallWidth;
	}

	public int getHallHeight() {
		return hallHeight;
	}

	public void setHallHeight(int hallHeight) {
		this.hallHeight = hallHeight;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	
	
	
	
}
