package lt.techin.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.techin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameValidator implements ConstraintValidator<Username, String> {

  @Autowired
  private UserService userService;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    if (username == null || username.trim().isEmpty()) {
      return false;
    }

    return !userService.isUsernameTaken(username);
  }
}
