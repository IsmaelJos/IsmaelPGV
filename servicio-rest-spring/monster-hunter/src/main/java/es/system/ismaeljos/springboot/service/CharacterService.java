package es.system.ismaeljos.springboot.service;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Character;
import es.system.ismaeljos.springboot.repository.CharacterRepository;
import es.system.ismaeljos.springboot.service.interfaces.CharacterServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class CharacterService implements CharacterServiceInterface {

    private CharacterRepository characterRepository;

    @Autowired
    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(@PathVariable(value = "id") int characterId) throws ResourceNotFoundException {
        return characterRepository.findById(characterId)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found for this id :: " + characterId));
    }

    public Character createCharacter(@Valid @RequestBody Character character) {
        return characterRepository.save(character);
    }


    public Character updateCharacter(@PathVariable(value = "id") int characterId,
                                 @Valid @RequestBody Character characterDetails) throws ResourceNotFoundException {
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found for this id :: " + characterId));

        character.setName(characterDetails.getName());
        character.setWeapons(characterDetails.getWeapons());
        character.setArmors(characterDetails.getArmors());
        return characterRepository.save(character);
    }


    public void deleteCharacter(@PathVariable(value = "id") int characterId) throws ResourceNotFoundException {
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found for this id :: " + characterId));

        characterRepository.delete(character);
    }
}
