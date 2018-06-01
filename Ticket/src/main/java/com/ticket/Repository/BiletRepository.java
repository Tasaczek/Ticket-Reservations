package com.ticket.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Bilet;

public interface BiletRepository extends CrudRepository<Bilet, Integer> {
	
	Bilet getBiletByImie(String i);
	Bilet getBiletByNazwisko(String n);
	Bilet getBiletById(int id);
	Bilet getBiletByMiejsce(int miejsce);
	List<Bilet> findBiletByFilmId(int id);
}
