package com.gmp.dungeonsanddragons.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.gmp.dungeonsanddragons.model.CharacterInfo;


public interface CharacterRepository extends CrudRepository<CharacterInfo, Long> {

	Page<CharacterInfo> findAllByUserEmail(String email, Pageable pageable);

	CharacterInfo findByNameAndUserEmail(String name, String email);
	
}
