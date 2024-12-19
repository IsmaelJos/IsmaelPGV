package es.system.IsmaelJos.springboot.service;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Monster;
import es.system.IsmaelJos.springboot.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MonsterServiceInterface {
    List<Monster> getAllMonsters();
    Monster getMonsterById(int MonsterId) throws ResourceNotFoundException;
    public Monster createMonster(Monster monster);
    Monster updateMonster(int monsterId, Monster monsterDetails) throws ResourceNotFoundException;
    void deleteMonster(int monsterId) throws ResourceNotFoundException;

}