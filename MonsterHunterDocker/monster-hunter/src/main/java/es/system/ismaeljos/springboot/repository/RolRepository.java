package es.system.ismaeljos.springboot.repository;

import es.system.ismaeljos.springboot.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
