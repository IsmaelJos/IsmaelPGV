package es.system.IsmaelJos.springboot.service;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Monster;
import es.system.IsmaelJos.springboot.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MonsterService implements MonsterServiceInterface{

    MonsterRepository monsterRepository;

    @Autowired
    public void setMonsterRepository(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    @Override
    public Monster getMonsterById(int MonsterId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Monster createMonster(Monster monster) {
        return null;
    }

    @Override
    public Monster updateMonster(int monsterId, Monster monsterDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void deleteMonster(int monsterId) throws ResourceNotFoundException {

    }
}
