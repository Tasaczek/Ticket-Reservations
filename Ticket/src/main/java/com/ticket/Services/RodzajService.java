package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Rodzaj;
import com.ticket.Repository.RodzajRepository;

@Service
@Transactional
public class RodzajService {
	private final RodzajRepository rodzajRepository;
	
	public RodzajService(RodzajRepository r) {
		this.rodzajRepository = r;
	}
	
	public List<Rodzaj> listaRodzajow(){
		List<Rodzaj> lista = new ArrayList<>();
		for(Rodzaj r:rodzajRepository.findAll()) {
			lista.add(r);
		}
		return lista;
	}
	
	public Rodzaj getRodzajById(int id) {
		return rodzajRepository.getRodzajById(id);
	}
}
