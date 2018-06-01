package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Rezyser;
import com.ticket.Repository.RezyserRepository;

@Service
@Transactional
public class RezyserService {

	private final RezyserRepository rRepository;
	
	public RezyserService(RezyserRepository rR) {
		this.rRepository=rR;
	}
	
	public List<Rezyser> listaRezyserow(){
		List<Rezyser> lista = new ArrayList<>();
		for(Rezyser r:rRepository.findAll()) {
			lista.add(r);
		}
		return lista;
	}
}
