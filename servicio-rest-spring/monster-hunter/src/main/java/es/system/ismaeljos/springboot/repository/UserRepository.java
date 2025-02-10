package es.system.ismaeljos.springboot.repository;

import es.system.ismaeljos.springboot.model.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.system.ismaeljos.springboot.model.User;

import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByName(String name);
    //void saveAndFlushUser(String name, String password, Roll roll);
}
