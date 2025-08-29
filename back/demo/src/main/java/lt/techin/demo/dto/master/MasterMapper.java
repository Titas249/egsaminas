package lt.techin.demo.dto.master;

import lt.techin.demo.dto.rating.RatingRequestDTO;
import lt.techin.demo.dto.rating.RatingResponseDTO;
import lt.techin.demo.dto.rating.UpdateRatingResponseDTO;
import lt.techin.demo.model.Master;
import lt.techin.demo.model.Rating;

public class MasterMapper {
    public static MasterResponseDTO toMasterResponseDTO(Master master) {
        return new MasterResponseDTO(master.getId(), master.getName(), master.getLastName(), master.getSpecialization(), master.getCity());
    }

    public static Master toMasterRequestDTO(MasterRequestDTO  masterRequestDTO) {
        Master  master = new Master();
        master.setCity(masterRequestDTO.city());
        master.setSpecialization(masterRequestDTO.specialization());
        master.setLastName(masterRequestDTO.lastName());
        master.setName(masterRequestDTO.name());

        return  master;
    }

    public static UpdateMasterResponseDTO toUpdateMasterResponseDTO(Master master) {
        return new UpdateMasterResponseDTO(
                master.getName(),
                master.getLastName(),
                master.getSpecialization(),
                master.getCity()
        );

    }
}
