package com.gmp.dungeonsanddragons.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gmp.dungeonsanddragons.model.CharacterInfo;
import com.gmp.dungeonsanddragons.model.User;
import com.gmp.dungeonsanddragons.repository.CharacterRepository;
import com.gmp.dungeonsanddragons.repository.UserRepository;


@Service
public class CharacterServiceImpl implements CharacterService {
	
	private CharacterRepository characterRepository;
	private UserRepository userRepository;

	
	public CharacterServiceImpl(CharacterRepository characterRepository, UserRepository userRepository) {
		this.characterRepository = characterRepository;
		this.userRepository = userRepository;
	}

	@Override
	public CharacterInfo save(CharacterInfo character) {
		 if (character == null) {
	            throw new IllegalArgumentException("Failed to save");
	        }
		 
		 CharacterInfo existingCharacterInfo = characterRepository.findByNameAndUserEmail(character.getName(), character.getUser().getEmail());
		 if (existingCharacterInfo != null) {
			 character.setId(existingCharacterInfo.getId());
			 character.setUser(existingCharacterInfo.getUser());
		 }
		 if (character.getUser().getId() == null || character.getUser().getId().equals(0L) ) {
			 User user = userRepository.findByEmail(character.getUser().getEmail());
			 if (user != null) {
				 character.setUser(user);
			 }
		 }
		 
		 return characterRepository.save(character);
	}

	
	public Page<CharacterInfo> getUserCharacter(String email, Pageable pageable) {

        if (email == null || !email.contains("@") || email.length() > 32) {
            throw new IllegalArgumentException("Invalid email address");
        }
        return characterRepository.findAllByUserEmail(email, pageable);
    }

}
