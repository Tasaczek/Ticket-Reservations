package com.ticket.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="gatunek")
public class Gatunek implements Serializable{

	@Id
	@Column(name="id")
	private int id;
	private String nazwa;
	
	@OneToMany(mappedBy = "gatunek")
	private Set<Film> filmy;
	
	public Gatunek() {
		
	}
	public Gatunek(String nazwa) {
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