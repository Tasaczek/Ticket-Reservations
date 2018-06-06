package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Bilet;
import com.ticket.Repository.BiletRepository;

@Service
@Transactional
public class BiletService {

	private final BiletRepository bRepository;
	
	public BiletService(BiletRepository br) {
		this.bRepository=br;
	}
	
	public List<Bilet> listaBiletow() {
		List<Bilet> bilety = new ArrayList<>();
		for(Bilet bilet:bRepository.findAll()) {
			bilety.add(bilet);
		}
		return bilety;
	}
	
	Bilet findBiletById(int id) {
		return bRepository.getBiletById(id);
	}
	
	public void rezerwujBilet(Bilet b) {
		bRepository.save(b);
	}
	
	public Bilet getBiletByMiejsce(int miejsce) {
		return bRepository.getBiletByMiejsce(miejsce);
	}
	
	public List<Integer> zarMiejsca(int film){
		List<Integer> miejsca = new ArrayList<>();
		for(Bilet b:bRepository.findBiletByFilmId(film)) {
			miejsca.add(b.getMiejsce());
		}
		return miejsca;
	}
	
	public void usunBilet(int id) {
		bRepository.deleteById(id);
	}
}
