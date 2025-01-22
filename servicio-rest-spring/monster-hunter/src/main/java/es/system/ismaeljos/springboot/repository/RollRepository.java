package es.system.ismaeljos.springboot.repository;

import es.system.ismaeljos.springboot.model.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollRepository extends JpaRepository<Roll, Integer>{

}
