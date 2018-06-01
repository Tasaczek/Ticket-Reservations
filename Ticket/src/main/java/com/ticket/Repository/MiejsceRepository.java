package com.ticket.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Miejsce;

public interface MiejsceRepository extends CrudRepository<Miejsce, Integer> {

	Miejsce getMiejsceByNumer(int numer);
	boolean getMiejsceByZarezerwowane(int id);
	boolean getMiejsceByBilet(int id);
}
