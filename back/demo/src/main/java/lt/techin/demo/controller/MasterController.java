package lt.techin.demo.controller;

import lt.techin.demo.dto.master.MasterMapper;
import lt.techin.demo.dto.master.MasterResponseDTO;
import lt.techin.demo.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class MasterController {

    private final MasterService masterService;

    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping("/master")
    public ResponseEntity<List<MasterResponseDTO>> getAllMaster() {
        return ResponseEntity.ok(
                masterService.findAllMaster().stream()
                        .map(MasterMapper::toMasterResponseDTO)
                        .toList()
        );
    }
}
