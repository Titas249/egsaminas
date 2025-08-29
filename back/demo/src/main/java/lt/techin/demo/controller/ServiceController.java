package lt.techin.demo.controller;

import lt.techin.demo.dto.service.ServiceMapper;
import lt.techin.demo.dto.service.ServiceResponseDTO;
import lt.techin.demo.service.ServiceService;
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
}
