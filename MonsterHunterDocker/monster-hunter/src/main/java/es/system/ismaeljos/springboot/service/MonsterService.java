package es.system.ismaeljos.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Monster;
import es.system.ismaeljos.springboot.repository.MonsterRepository;
import es.system.ismaeljos.springboot.service.interfaces.MonsterServiceInterface;
import jakarta.validation.Valid;
@Component
public class MonsterService implements MonsterServiceInterface {

    private MonsterRepository monsterRepository;

    @Autowired
    public void setMonsterRepository(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }

    public Monster getMonsterById(@PathVariable(value = "id") int monsterId) throws ResourceNotFoundException {
        return monsterRepository.findById(monsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found for this id :: " + monsterId));
    }

    public Monster createMonster(@Valid @RequestBody Monster monster) {
        return monsterRepository.save(monster);
    }


    public Monster updateMonster(@PathVariable(value = "id") int monsterId,
                           @Valid @RequestBody Monster monsterDetails) throws ResourceNotFoundException {
        Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found for this id :: " + monsterId));

        monster.setName(monsterDetails.getName());
        monster.setDescription(monsterDetails.getDescription());
        return monsterRepository.save(monster);
    }


    public void deleteMonster(@PathVariable(value = "id") int monsterId) throws ResourceNotFoundException {
        Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new ResourceNotFoundException("Monster not found for this id :: " + monsterId));

        monsterRepository.delete(monster);
    }
}
