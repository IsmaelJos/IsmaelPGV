package es.system.ismaeljos.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.system.ismaeljos.springboot.model.Monster;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {

}