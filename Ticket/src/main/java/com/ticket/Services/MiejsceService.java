package com.ticket.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Bilet;
import com.ticket.Model.Miejsce;
import com.ticket.Repository.MiejsceRepository;

@Service
@Transactional
public class MiejsceService {
	
	private final MiejsceRepository mRepository;
	
	public MiejsceService(MiejsceRepository mR) {
		this.mRepository = mR;
	}
	
	public Miejsce getMiejsceByNumer(int numer) {
		return mRepository.getMiejsceByNumer(numer);
	}
}
