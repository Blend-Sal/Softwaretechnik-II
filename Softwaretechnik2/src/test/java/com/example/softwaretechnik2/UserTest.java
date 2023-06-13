package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import com.example.softwaretechnik2.model.User;
import com.example.softwaretechnik2.repositories.UserRepository;
import com.example.softwaretechnik2.services.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
    @InjectMocks
    private User user;

    private UserService users;

    @Mock
    private UserRepository userRepository;

    public UserTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFirstNameValidation() {
        user.setFirstName(""); // Set an invalid first name (empty string)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty()); // Ensure that validation fails
    }

    @Test
    public void testLastNameValidation() {
        user.setLastName("A"); // Set an invalid last name (less than 2 characters)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty()); // Ensure that validation fails
    }

    @Test
    public void testEmailValidation() {
        user.setEmail("invalid_email"); // Set an invalid email address
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty()); // Ensure that validation fails
    }

}
