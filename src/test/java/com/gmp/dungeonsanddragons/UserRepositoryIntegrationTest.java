package com.gmp.dungeonsanddragons;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.gmp.dungeonsanddragons.model.User;
import com.gmp.dungeonsanddragons.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryIntegrationTest {
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByEmail_thenReturnUser() {
        User user = new User("abc@123.com", "ABC");
        entityManager.persistAndFlush(user);

        User found = userRepository.findByEmail("abc@123.com");
        assertEquals(found.getName(), user.getName());
    }
    
    @Test
    public void whenInvalidEmail_thenReturnNull() {
        User found = userRepository.findByEmail("a@b.com");
        assertNull(found);
    }
	
	
	
}
