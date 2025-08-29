package lt.techin.demo.dto.user;

import java.util.List;

public record LoginResponseDTO(String username, List<String> roles) {
}
