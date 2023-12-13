package com.example.mlmsystem.controller;

import com.example.mlmsystem.model.User;
import com.example.mlmsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterUser() throws Exception {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("securepassword");

        when(userService.registerUser(any(User.class))).thenReturn(user);

        ResultActions result = mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"John Doe\", \"email\": \"john@example.com\", \"password\": \"securepassword\" }"));

        result.andExpect(status().isOk());
        // Add more assertions as needed
    }

    // Add more tests for other UserController methods
}