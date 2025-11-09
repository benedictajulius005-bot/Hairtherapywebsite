package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.UserDto;
import com.hairtherapy.hairtherapy.entity.Role;
import com.hairtherapy.hairtherapy.entity.User;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser_Success(){

        UserDto dto = new UserDto();
        dto.setName("Ali");
        dto.setEmail("ali@gmail.com");
        dto.setPassword("13354");
        dto.setRole(Role.CLIENT);

        User savedUser = new User(1, "Ali", "ali@gmail.com", "13354", Role.CLIENT);
        when (userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDto result = userService.addUser(dto);

        assertNotNull(result);
        assertEquals("Ali", result.getName());
        assertEquals("ali@gmail.com", result.getEmail());
        assertEquals(Role.CLIENT, result.getRole());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterUser_EmailAlreadyExists() {
        // Given
        UserDto dto = new UserDto();
        dto.setName("Ali");
        dto.setEmail("ali@gmail.com");
        dto.setPassword("12345");
        dto.setRole(Role.CLIENT);

        // Simulate: email already exists in the database
        when(userRepository.existsByEmail(dto.getEmail())).thenReturn(true);

        // When + Then: expect an exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.addUser(dto);
        });

        assertEquals("Email already exists", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }







}
