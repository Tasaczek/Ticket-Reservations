package com.ticket.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Bilet;

public interface BiletRepository extends CrudRepository<Bilet, Integer> {

	Bilet getBiletById(int id);
	Bilet getBiletByFilmIdAndMiejsce(int id, int miejsce);
	List<Bilet> findBiletByFilmId(int id);
}
