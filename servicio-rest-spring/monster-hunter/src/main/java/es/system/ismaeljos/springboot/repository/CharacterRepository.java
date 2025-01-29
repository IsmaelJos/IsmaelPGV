package es.system.ismaeljos.springboot.repository;

import es.system.ismaeljos.springboot.model.Armor;
import es.system.ismaeljos.springboot.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

}
