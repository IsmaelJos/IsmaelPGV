package es.system.IsmaelJos.springboot.repository;

import es.system.IsmaelJos.springboot.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {

}