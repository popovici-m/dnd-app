package com.gmp.dungeonsanddragons;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.gmp.dungeonsanddragons.model.CharacterInfo;
import com.gmp.dungeonsanddragons.model.User;
import com.gmp.dungeonsanddragons.repository.CharacterRepository;
import com.gmp.dungeonsanddragons.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

@DataJpaTest
public class CharacterRepositoryIntegrationTest {
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CharacterRepository characterRepository;
    

    @Test
    public void whenFindByEmail_thenReturnUserCharacter() {
    	String email = "abc@123.com";
    	String characterName = "Test A";
    	
    	User user = new User(email, "ABC");
        userRepository.save(user);
    	
    	CharacterInfo characterInfo = new CharacterInfo(characterName, "Level 1", "Bard", "Human", 
    			Arrays.asList("knife", "axe"), Arrays.asList("light", "blackout"));
    	characterInfo.setUser(user);
    	
    	characterRepository.save(characterInfo);
    	
    	CharacterInfo found = characterRepository.findByNameAndUserEmail(characterName, email);

    	assertEquals(found, characterInfo);
    }
    
}
