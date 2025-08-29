package lt.techin.demo.dto.user;

import lt.techin.demo.model.Role;

import java.util.List;

public record UserResponseDTO(long id,
                              String username, String password, List<Role> roles
) {


}
