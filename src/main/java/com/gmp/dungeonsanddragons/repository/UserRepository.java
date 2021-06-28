package com.gmp.dungeonsanddragons.repository;

import org.springframework.data.repository.CrudRepository;

import com.gmp.dungeonsanddragons.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

}
