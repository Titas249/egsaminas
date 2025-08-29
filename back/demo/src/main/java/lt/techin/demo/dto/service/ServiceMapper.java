package lt.techin.demo.dto.service;

import lt.techin.demo.model.Services;

public class ServiceMapper {

    public static ServiceResponseDTO toServiceResponseDTO(Services service) {
        return new ServiceResponseDTO(service.getId(), service.getServiceName(), service.getAddress());
    }

    public static Services toServiceRequestDTO(ServiceRequestDTO serviceRequestDTO) {
        Services service = new Services();
        service.setServiceName(serviceRequestDTO.serviceName());
        service.setAddress(serviceRequestDTO.address());


        return service;
    }

    public static UpdateServiceResponseDTO toUpdateServiceResponseDTO(Services service) {
        return new UpdateServiceResponseDTO(
                service.getServiceName(),
                service.getAddress()
        );

    }
}
