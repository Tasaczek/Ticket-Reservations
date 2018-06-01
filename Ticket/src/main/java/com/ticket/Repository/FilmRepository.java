package com.ticket.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {
	Film getFilmById(int id);
}
