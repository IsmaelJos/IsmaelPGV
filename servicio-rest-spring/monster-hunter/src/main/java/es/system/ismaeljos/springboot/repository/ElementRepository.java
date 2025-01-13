package es.system.ismaeljos.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.system.ismaeljos.springboot.model.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {

}
