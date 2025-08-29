package lt.techin.demo.controller;

import lt.techin.demo.dto.master.MasterMapper;
import lt.techin.demo.dto.master.MasterResponseDTO;
import lt.techin.demo.model.Master;
import lt.techin.demo.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class MasterController {

    private final MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping("/masters")
    public ResponseEntity<List<MasterResponseDTO>> getAllMaster() {
        return ResponseEntity.ok(
                masterService.findAllMaster().stream()
                        .map(MasterMapper::toMasterResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/masters/{id}")
    public ResponseEntity<MasterResponseDTO> getMasterById(@PathVariable long id) {
        Optional<Master> maybeMaster = masterService.findMasterById(id);

        if (maybeMaster.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        MasterResponseDTO response = MasterMapper.toMasterResponseDTO(maybeMaster.get());
        return ResponseEntity.ok(response);
    }


}
