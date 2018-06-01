package com.ticket.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="miejsce")
public class Miejsce implements Serializable {
	
	@Id
	private int id;
	private int numer;
	private boolean zarezerwowane;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Bilet bilet;

	public Miejsce() {
		
	}
	
	public Miejsce(int numer, boolean zarezerwowane, Bilet bilet) {
		super();
		this.numer = numer;
		this.zarezerwowane = zarezerwowane;
		this.bilet = bilet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumer() {
		return numer;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}

	public boolean isZarezerwowane() {
		return zarezerwowane;
	}

	public void setZarezerwowane(boolean zarezerwowane) {
		this.zarezerwowane = zarezerwowane;
	}

	public Bilet getBilet() {
		return bilet;
	}

	public void setBilet(Bilet bilet) {
		this.bilet = bilet;
	}	
}
