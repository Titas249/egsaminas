package lt.techin.demo.controller;

import jakarta.validation.Valid;
import lt.techin.demo.dto.user.UpdateUserRequestDTO;
import lt.techin.demo.dto.user.UserMapper;
import lt.techin.demo.dto.user.UserResponseDTO;
import lt.techin.demo.model.User;
import lt.techin.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers().stream().map(UserMapper::toUserResponseDTO).toList());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable long id) {
        Optional<User> maybeUser = userService.findUserById(id);

        if (maybeUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UserResponseDTO response = UserMapper.toUserResponseDTO(maybeUser.get());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @Valid @RequestBody UpdateUserRequestDTO updateUserRequestDTO) {
        if (userService.existsUserById(id)) {
            User userFromDb = userService.findUserById(id).get();

            userFromDb.setUsername(updateUserRequestDTO.username());
            userFromDb.setUsername(updateUserRequestDTO.password());

            User savedUser = userService.saveUser(userFromDb);

            return ResponseEntity.ok(UserMapper.toUpdateUserResponseDTO(savedUser));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        if (!userService.existsUserById(id)) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }
}
