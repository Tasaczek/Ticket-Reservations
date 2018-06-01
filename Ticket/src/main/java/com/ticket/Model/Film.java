package com.ticket.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film implements Serializable {

	@Id
	private int id;
	private String tytul;
	private String opis;
	
	@ManyToOne
	@JoinColumn(name="gatunek")
	private Gatunek gatunek;
	
	@ManyToOne
	@JoinColumn(name="rezyser")
	private Rezyser rezyser;
	
	@ManyToOne
	@JoinColumn(name="wersja")
	private Wersja wersja;
	
	@ManyToOne
	@JoinColumn(name="termin")
	private Termin termin;
	
	public Film() {
		
	}


	public Film(String tytul, String opis, Gatunek gatunek, Rezyser rezyser, Wersja wersja, Termin termin) {
		super();
		this.tytul = tytul;
		this.opis = opis;
		this.gatunek = gatunek;
		this.rezyser = rezyser;
		this.wersja = wersja;
		this.termin = termin;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Gatunek getGatunek() {
		return gatunek;
	}

	public void setGatunek(Gatunek gatunek) {
		this.gatunek = gatunek;
	}

	public Rezyser getRezyser() {
		return rezyser;
	}

	public void setRezyser(Rezyser rezyser) {
		this.rezyser = rezyser;
	}


	public Wersja getWersja() {
		return wersja;
	}


	public void setWersja(Wersja wersja) {
		this.wersja = wersja;
	}


	public Termin getTermin() {
		return termin;
	}


	public void setTermin(Termin termin) {
		this.termin = termin;
	}
}



