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

	private static final long serialVersionUID = 1L;
	
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
	
	@OneToMany(mappedBy="film", fetch=FetchType.EAGER)
	private Set<Bilet> bilety;
	
	@OneToMany(mappedBy="film", fetch=FetchType.EAGER)
	private Set<Wersja> wersje;
	
	@OneToMany(mappedBy="film", fetch=FetchType.EAGER)
	private Set<Termin> terminy;
	
	public Film() {
		
	}

	public Film(String tytul, String opis, Gatunek gatunek, Rezyser rezyser, Set<Bilet> bilety, Set<Wersja> wersje,
			Set<Termin> terminy) {
		super();
		this.tytul = tytul;
		this.opis = opis;
		this.gatunek = gatunek;
		this.rezyser = rezyser;
		this.bilety = bilety;
		this.wersje = wersje;
		this.terminy = terminy;
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

	public Set<Bilet> getBilety() {
		return bilety;
	}

	public void setBilety(Set<Bilet> bilety) {
		this.bilety = bilety;
	}

	public Set<Wersja> getWersje() {
		return wersje;
	}

	public void setWersje(Set<Wersja> wersje) {
		this.wersje = wersje;
	}

	public Set<Termin> getTerminy() {
		return terminy;
	}

	public void setTerminy(Set<Termin> terminy) {
		this.terminy = terminy;
	}
	
}



