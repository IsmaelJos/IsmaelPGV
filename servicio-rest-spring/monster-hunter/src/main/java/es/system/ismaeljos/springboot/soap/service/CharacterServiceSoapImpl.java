package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Character;
import es.system.ismaeljos.springboot.service.interfaces.CharacterServiceInterface;
import es.system.ismaeljos.springboot.soap.service.interfaces.CharacterServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.CharacterServiceSoapInterface")
public class CharacterServiceSoapImpl implements CharacterServiceSoapInterface {
    private CharacterServiceInterface characterService;

    @Autowired
    public void setCharacterRepository(CharacterServiceInterface characterService) {
        this.characterService = characterService;
    }

    @Override
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @Override
    public Character getCharacterById(int characterId) {
        try {
            return characterService.getCharacterById(characterId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo la armadura", e);
        }
    }

    @Override
    public boolean deleteById(int characterId) {
        try{
            characterService.deleteCharacter(characterId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createCharacter(Character character) {
        try{
            characterService.createCharacter(character);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCharacter(int characterId, Character character) {
        try{
            characterService.updateCharacter(characterId, character);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
