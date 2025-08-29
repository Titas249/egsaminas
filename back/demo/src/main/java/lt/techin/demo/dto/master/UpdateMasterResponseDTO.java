package lt.techin.demo.dto.master;

public record UpdateMasterResponseDTO(
        String name,
        String lastName,
        String specialization,
        String city) {
}
