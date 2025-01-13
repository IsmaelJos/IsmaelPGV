package es.system.ismaeljos.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.system.ismaeljos.springboot.model.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}