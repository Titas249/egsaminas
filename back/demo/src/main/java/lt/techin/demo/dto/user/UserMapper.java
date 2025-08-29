package lt.techin.demo.dto.user;

import lt.techin.demo.model.Role;
import lt.techin.demo.model.User;

public class UserMapper {

  public static UserResponseDTO toUserResponseDTO(User user) {
    return new UserResponseDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRoles());
  }

  public static User toUserRequestDTO(UserRequestDTO userRequestDTO) {
    User user = new User();
    user.setRoles(userRequestDTO.roles());
    user.setUsername(userRequestDTO.username());
    user.setPassword(userRequestDTO.password());

    return user;
  }

  public static UpdateUserResponseDTO toUpdateUserResponseDTO(User user) {
    return new UpdateUserResponseDTO(
            user.getUsername(),
            user.getPassword()
    );

  }

  public static LoginResponseDTO toLoginResponseDTO(User user) {
    return new LoginResponseDTO(
            user.getUsername(),
            user.getRoles()
                    .stream()
                    .map(Role::getName)
                    .toList()
    );
  }

}
