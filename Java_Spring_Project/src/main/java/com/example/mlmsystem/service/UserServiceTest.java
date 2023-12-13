package com.example.mlmsystem.service;

import com.example.mlmsystem.model.User;
import com.example.mlmsystem.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("securepassword");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User registeredUser = userService.registerUser(user);

        assertEquals("John Doe", registeredUser.getName());
        // Add more assertions as needed
    }

    // Add more tests for other UserService methods
}