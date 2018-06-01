package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Wersja;
import com.ticket.Repository.WersjaRepository;

@Service
@Transactional
public class WersjaService {

	private final WersjaRepository wRepository;
	
	public WersjaService(WersjaRepository wR) {
		this.wRepository=wR;
	}
	
	public List<Wersja> listaWersji(){
		List<Wersja> wersje = new ArrayList<>();
		for(Wersja w:wRepository.findAll()) {
			wersje.add(w);
		}
		return wersje;
	}
}
