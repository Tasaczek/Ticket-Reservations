package com.ticket.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ticket.Model.Users;

public interface UzytkownikRepository extends CrudRepository<Users, Integer> {
	Optional<Users> findByUsername(String username);			//bo może go nie być w bazie
	Users findUzytkownikById(int id);
	Users findByUsernameAndPassword(String username, String password);
}
