package com.ticket.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Rodzaj;

public interface RodzajRepository extends CrudRepository<Rodzaj, Integer> {
	
	Rodzaj getRodzajById(int id);
}
