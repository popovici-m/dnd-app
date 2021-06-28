package com.gmp.dungeonsanddragons.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import com.gmp.dungeonsanddragons.model.CharacterInfo;

@Validated
public interface CharacterService {

	CharacterInfo save(CharacterInfo character);
	 
	Page<CharacterInfo> getUserCharacter(String email, Pageable pageable);
}
