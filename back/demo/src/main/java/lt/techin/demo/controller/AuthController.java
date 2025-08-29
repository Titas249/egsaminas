package lt.techin.demo.controller;

import lt.techin.demo.dto.user.LoginResponseDTO;
import lt.techin.demo.dto.user.UserMapper;
import lt.techin.demo.model.User;
import lt.techin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<LoginResponseDTO> loginUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(UserMapper.toLoginResponseDTO(user));
    }

}