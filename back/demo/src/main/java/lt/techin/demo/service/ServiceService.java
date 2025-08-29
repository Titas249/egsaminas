package lt.techin.demo.service;

import lt.techin.demo.model.Services;
import lt.techin.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Collection<Services> findAllService() {
        return serviceRepository.findAll();
    }
}
