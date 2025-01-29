package es.system.ismaeljos.springboot.service.interfaces;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Character;

import java.util.List;

public interface CharacterServiceInterface {
    List<Character> getAllCharacters();
    Character getCharacterById(int CharacterId) throws ResourceNotFoundException;
    public Character createCharacter(Character character);
    Character updateCharacter(int characterId, Character characterDetails) throws ResourceNotFoundException;
    void deleteCharacter(int characterId) throws ResourceNotFoundException;
}
