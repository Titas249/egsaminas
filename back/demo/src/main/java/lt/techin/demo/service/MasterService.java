package lt.techin.demo.service;

import lt.techin.demo.model.Master;
import lt.techin.demo.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MasterService {

    private final MasterRepository masterRepository;

    @Autowired
    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public Collection<Master> findAllMaster() {
        return masterRepository.findAll();
    }
}
