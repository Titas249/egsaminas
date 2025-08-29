package lt.techin.demo.controller;

import lt.techin.demo.dto.service.ServiceMapper;
import lt.techin.demo.dto.service.ServiceResponseDTO;
import lt.techin.demo.model.Services;
import lt.techin.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/services")
    public ResponseEntity<List<ServiceResponseDTO>> getAllService(){
        return ResponseEntity.ok(
                serviceService.findAllService().stream()
                        .map(ServiceMapper::toServiceResponseDTO)
                        .toList()
        );
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<ServiceResponseDTO> getServiceById(@PathVariable long id) {
        Optional<Services> maybeService = ServiceService.findServiceById(id);

        if (maybeService.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ServiceResponseDTO response = ServiceMapper.toServiceResponseDTO(maybeService.get());
        return ResponseEntity.ok(response);
    }
}
