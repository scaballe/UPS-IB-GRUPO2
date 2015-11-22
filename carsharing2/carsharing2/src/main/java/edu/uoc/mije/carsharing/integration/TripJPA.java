package edu.uoc.mije.carsharing.integration;

import java.io.Serializable;

import javax.persistence.*;

@Entity

public class TripJPA implements Serializable {

	private static final long serialVersionUID = 1L;

	public TripJPA() {
		// TODO Auto-generated constructor stub
	}
	
	Integer id;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


}
