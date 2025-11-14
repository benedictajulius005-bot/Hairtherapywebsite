package com.hairtherapy.hairtherapy.integration;


import com.hairtherapy.hairtherapy.dto.UserDto;
import com.hairtherapy.hairtherapy.entity.Role;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser_User(){
        UserDto dto = new UserDto();
        dto.setName("Ali");
        dto.setEmail("ali@example.com");
        dto.setPassword("123456");
        dto.setRole(Role.CLIENT);

        UserDto savedUser = userService.addUser(dto);
        assertNotNull(savedUser);
        assertTrue(userRepository.existsByEmail("ali@example.com"));
    }

    @Test
    void testCreateUser_DuplicateEmail_ThrowsException() {
        UserDto dto = new UserDto();
        dto.setName("Ali");
        dto.setEmail("ali@example.com");
        dto.setPassword("123456");
        dto.setRole(Role.CLIENT);

        userService.addUser(dto);

        // Second time with same email
        UserDto duplicate = new UserDto();
        duplicate.setName("Ali2");
        duplicate.setEmail("ali" +
                "@example.com");
        duplicate.setPassword("abcdef");
        duplicate.setRole(Role.CLIENT);

        assertThrows(RuntimeException.class, () -> userService.addUser(duplicate));
    }
}
