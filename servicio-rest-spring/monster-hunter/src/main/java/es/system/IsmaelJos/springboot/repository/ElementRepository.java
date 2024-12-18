package es.system.IsmaelJos.springboot.repository;

import es.system.IsmaelJos.springboot.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {

}
