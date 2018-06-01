package com.ticket.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rodzaj")
public class Rodzaj implements Serializable {

	@Id
	private int id;
	private String nazwa;
	private String cena;
	
	@OneToMany(mappedBy="rodzaj", fetch=FetchType.EAGER)
	private Set<Bilet> bilety;

	public Rodzaj() {
		
	}
	
	public Rodzaj(String nazwa, String cena, Set<Bilet> bilety) {
		super();
		this.nazwa = nazwa;
		this.cena = cena;
		this.bilety = bilety;
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

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public Set<Bilet> getBilety() {
		return bilety;
	}

	public void setBilety(Set<Bilet> bilety) {
		this.bilety = bilety;
	}
}
