package es.system.ismaeljos.springboot.service.interfaces;

import java.util.List;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Monster;

public interface MonsterServiceInterface {
    List<Monster> getAllMonsters();
    Monster getMonsterById(int MonsterId) throws ResourceNotFoundException;
    public Monster createMonster(Monster monster);
    Monster updateMonster(int monsterId, Monster monsterDetails) throws ResourceNotFoundException;
    void deleteMonster(int monsterId) throws ResourceNotFoundException;

}