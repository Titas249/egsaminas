package lt.techin.demo.dto.master;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateMasterRequestDTO(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String lastName,
        @NotNull
        @NotBlank
        String specialization,
        @NotNull
        @NotBlank
        String city) {


}
