package com.ticket.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {
	Film getFilmById(int id);
	
	List <Film> getFilmsByGatunekId(int id);
	List <Film> getFilmsByWersjaId(int id);
	List <Film> getFilmsByRezyserId(int id);
	List <Film> getFilmsByTerminId(int id);
}
