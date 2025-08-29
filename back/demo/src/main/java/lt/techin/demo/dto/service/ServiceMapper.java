package lt.techin.demo.dto.service;

import lt.techin.demo.model.Service;
import lt.techin.demo.model.User;

public class ServiceMapper {

    public static ServiceResponseDTO toServiceResponseDTO(Service service) {
        return new ServiceResponseDTO(service.getId(), service.getServiceName(), service.getAddress());
    }

    public static Service toServiceRequestDTO(ServiceRequestDTO serviceRequestDTO) {
        Service service = new Service();
        service.setServiceName(serviceRequestDTO.serviceName());
        service.setAddress(serviceRequestDTO.address());


        return service;
    }

    public static UpdateServiceResponseDTO toUpdateServiceResponseDTO(Service service) {
        return new UpdateServiceResponseDTO(
                service.getServiceName(),
                service.getAddress()
        );

    }
}
