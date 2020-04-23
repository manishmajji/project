package com.cg.entity;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="theatres")
public class Theatre {

	@Id
	@Column(name="theatre_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer theatreId;
	
	@Column(name="theatre_name")
	private String theatreName;
	
	@Column(name="theatre_city")
	private String theatreCity;
	
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinTable(name="movie_theatre",
	joinColumns=@JoinColumn(name="theatre_id"),
	inverseJoinColumns=@JoinColumn(name="movie_id"))
	@Column(name="movie_id")
	private Set<Movie> listOfMovies;
	
    @OneToMany(
            mappedBy = "theatre",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
	private List<Screen> listOfScreens;
	
    @Column(name="manager_name")
    private String managerName;
    
    @Column(name="manager_contact")
	private String managerContact;

	public Theatre() {
		super();
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public Set<Movie> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(Set<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
    
    
}