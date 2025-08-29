package lt.techin.demo.repository;

import lt.techin.demo.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ServiceRepository extends JpaRepository<Services, Long> {

}
