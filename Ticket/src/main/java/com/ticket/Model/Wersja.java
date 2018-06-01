package com.ticket.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="wersja")
public class Wersja implements Serializable {

	@Id
	private int id;
	private String nazwa;
	
	@ManyToOne
	@JoinColumn(name="film")
	private Film film;
	
	public Wersja() {
		
	}
	
	public Wersja(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	
}
