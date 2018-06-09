package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Film;
import com.ticket.Repository.FilmRepository;

@Service
@Transactional
public class FilmService {

	private final FilmRepository fRepository;
	
	public FilmService(FilmRepository fr) {
		this.fRepository=fr;
	}
	
	public List<Film> showAllFilms() {
		List<Film> filmy = new ArrayList<>();
		for(Film film:fRepository.findAll()) {
			filmy.add(film);
		}
		return filmy;
	}
	
	public Film getFilmById(int id) {
		Film film = fRepository.getFilmById(id);
		
		return film;
	}
}
