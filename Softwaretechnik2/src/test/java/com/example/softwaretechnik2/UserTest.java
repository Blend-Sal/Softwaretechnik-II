package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class UserTest {
    @InjectMocks
    private User user;

    public UserTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFirstNameValidation() {
        user.setFirstName("");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    @Test
    public void testLastNameValidation() {
        user.setLastName("A");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    @Test
    public void testEmailValidation() {
        user.setEmail("invalid_email");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

}
