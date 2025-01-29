package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Character;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "springboot.soap.service")
public interface CharacterServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="character")
    List<Character> getAllCharacters();

    @WebMethod
    Character getCharacterById(@WebParam(name = "characterId") int characterId);

    @WebMethod
    boolean deleteById(@WebParam(name = "characterId") int characterId);

    @WebMethod
    boolean createCharacter(@WebParam(name = "characterCreated") Character character);

    @WebMethod
    boolean updateCharacter(@WebParam(name = "characterUpdated") int characterId, Character character);
}
