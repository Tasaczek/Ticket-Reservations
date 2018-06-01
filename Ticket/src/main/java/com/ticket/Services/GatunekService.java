package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Gatunek;
import com.ticket.Repository.GatunekRepository;

@Service
@Transactional
public class GatunekService {

	private final GatunekRepository gRepository;
	
	public GatunekService(GatunekRepository gr) {
		this.gRepository=gr;
	}
	
	public List<Gatunek> listaGatunkow(){
		List<Gatunek> gatunki = new ArrayList<>();
		for(Gatunek g:gRepository.findAll()) {
			gatunki.add(g);
		}
		return gatunki;
	}
	
	public Optional<Gatunek> findByNazwa(String nazwa) {
		Optional<Gatunek> g = gRepository.findByNazwa(nazwa);		
		return g;		
	}
}
