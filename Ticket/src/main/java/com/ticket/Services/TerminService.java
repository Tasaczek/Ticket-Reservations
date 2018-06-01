package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Termin;
import com.ticket.Repository.TerminRepository;

@Service
@Transactional
public class TerminService {
private final TerminRepository tRepository;
	
	public TerminService(TerminRepository tr) {
		this.tRepository=tr;
	}
	
	public List<Termin> listaTerminow() {
		List<Termin> terminy = new ArrayList<>();
		for(Termin termin:tRepository.findAll()) {
			terminy.add(termin);
		}
		return terminy;
	}
}
