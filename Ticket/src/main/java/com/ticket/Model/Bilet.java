package com.ticket.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bilet")
public class Bilet implements Serializable {

	@Id
	private int id;
	private String imie;
	private String nazwisko;
	private int miejsce;
	
	@ManyToOne
	@JoinColumn(name="film")
	private Film film;
	
	@ManyToOne
	@JoinColumn(name="rodzaj")
	private Rodzaj rodzaj;
	
	//@OneToOne(mappedBy="bilet")
	//private Miejsce miejsce;
	
	public Bilet() {
		
	}

	public Bilet(String imie, String nazwisko, Film film, Rodzaj rodzaj, int miejsce) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.film = film;
		this.rodzaj = rodzaj;
		this.miejsce = miejsce;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Rodzaj getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(Rodzaj rodzaj) {
		this.rodzaj = rodzaj;
	}

	public int getMiejsce() {
		return miejsce;
	}

	public void setMiejsce(int miejsce) {
		this.miejsce = miejsce;
	}

}
