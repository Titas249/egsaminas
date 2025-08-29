package lt.techin.demo.dto.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateServiceRequestDTO(
        @NotNull
        @NotBlank
        String serviceName,
        @NotNull
        @NotBlank
        String address) {


}
