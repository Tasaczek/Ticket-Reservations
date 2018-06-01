package com.ticket.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Gatunek;

public interface GatunekRepository extends CrudRepository<Gatunek, Integer> {

	Optional<Gatunek> findByNazwa(String nazwa);
}
