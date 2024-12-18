package es.system.IsmaelJos.springboot.repository;

import es.system.IsmaelJos.springboot.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}