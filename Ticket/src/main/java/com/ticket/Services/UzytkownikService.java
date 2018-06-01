package com.ticket.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.Model.Users;
import com.ticket.Repository.UzytkownikRepository;

@Service
@Transactional
public class UzytkownikService {

	private final UzytkownikRepository uRepository;
	
	public UzytkownikService(UzytkownikRepository ur) {
		this.uRepository=ur;
	}
	
	public Users findUserById(int id) {
		return uRepository.findUzytkownikById(id);
	}
	
	public Users findUserByLoginAndPassword(String username, String password) {
		return uRepository.findByUsernameAndPassword(username, password);
	}
}
