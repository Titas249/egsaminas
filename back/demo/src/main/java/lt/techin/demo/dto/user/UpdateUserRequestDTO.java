package lt.techin.demo.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lt.techin.demo.validation.Username;

public record UpdateUserRequestDTO(@NotNull
                                   @Size(min = 3, max = 100)
                                   String username,
                                   @Size(min = 8)
                                   String password) {


}
