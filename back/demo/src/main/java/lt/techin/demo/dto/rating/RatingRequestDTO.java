package lt.techin.demo.dto.rating;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RatingRequestDTO(long id,
                               @NotNull
                             @NotBlank
                             @Size(min = 1, max = 5)
                             long rate) {

}
