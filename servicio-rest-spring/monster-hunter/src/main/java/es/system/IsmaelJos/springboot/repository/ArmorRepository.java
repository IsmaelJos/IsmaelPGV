package es.system.IsmaelJos.springboot.repository;

import es.system.IsmaelJos.springboot.model.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Integer> {

}
