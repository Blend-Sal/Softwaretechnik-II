package com.example.softwaretechnik2;

import com.example.softwaretechnik2.model.Role;
import com.example.softwaretechnik2.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;

@SpringBootTest
public class UserTest {
    @InjectMocks
    private User user;

    public UserTest() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void setFirstandLastNameLength(){
        User user = new User();
        user.setFirstName("Ichbinüberzwanzigzeichenlang");
        user.setLastName("ichbinauchüberzwanzigzeichenlang");
        assertTrue(user.getFirstName().length() > 20);
        assertTrue(user.getLastName().length() > 20);
    }

    @Test
    void setEmailLength() {
        User user = new User();
        User user1 = new User();
        user.setEmail("ichbineinetestemaildieüberfünfundfünfzigzeichenlangist@gmail.com");
        user1.setEmail("kurze@gmail.com");
        assertTrue(user.getEmail().length() > 55);
        assertTrue(user1.getEmail().length() < 55);
    }


    // Test if the User's profile picture validation works correctly
    @Test
    void testProfilePictureValidation() {
        user.setProfilBild(null); // No specific constraints on profile picture
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    // Test if the User's password validation works correctly
    @Test
    void testPasswordValidation() {
        user.setPassword("");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    // Test if the User's confirmed password validation works correctly
    @Test
    void testConfirmedPasswordValidation() {
        user.setConfirmedPassword("");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    // Test if the User's roles validation works correctly
    @Test
    void testRolesValidation() {
        Role role1 = new Role();
        role1.setName("ROLE_CLIENT");
        Role role2 = new Role();
        role2.setName("ROLE_EMPLOYEE");

        user.setRoles(Arrays.asList(role1, role2));
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    // Test if the User's first name validation works correctly
    @Test
    void testFirstNameValidation() {
        user.setFirstName("");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    // Test if the User's last name validation works correctly
    @Test
    void testLastNameValidation() {
        user.setLastName("A");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }

    // Test if the User's email validation works correctly
    @Test
    void testEmailValidation() {
        user.setEmail("invalid_email");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        assertFalse(validator.validate(user).isEmpty());
    }
}

