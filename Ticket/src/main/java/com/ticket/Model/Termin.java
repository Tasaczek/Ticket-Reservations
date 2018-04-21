package com.ticket.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="termin")
public class Termin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String godzina;
	private String dzien;
	
	@ManyToOne
	@JoinColumn(name="film")
	private Film film;
	
	public Termin() {
		
	}
	
	public Termin(String godzina, String dzien) {
		super();
		this.godzina = godzina;
		this.dzien = dzien;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGodzina() {
		return godzina;
	}
	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
	public String getDzien() {
		return dzien;
	}
	public void setDzien(String dzien) {
		this.dzien = dzien;
	}
	
}
