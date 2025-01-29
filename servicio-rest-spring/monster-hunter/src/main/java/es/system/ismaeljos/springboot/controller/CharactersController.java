package es.system.ismaeljos.springboot.controller;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Character;
import es.system.ismaeljos.springboot.service.interfaces.CharacterServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/characters")
public class CharactersController {
    private CharacterServiceInterface characterservice;

    @Autowired
    public void setCharacterRepository(CharacterServiceInterface characterservice) {
        this.characterservice = characterservice;
    }


    @Operation(summary = "Get all characters")
    @GetMapping("/")
    public List<Character> getAllCharacters() {
        return characterservice.getAllCharacters();
    }

    @Operation(summary = "Get character by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Character not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable(value = "id") int characterId) throws ResourceNotFoundException {
        Character character = characterservice.getCharacterById(characterId);
        return ResponseEntity.ok().body(character);
    }

    @Operation(summary = "Insert character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Character created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Character createCharacter(@Valid @RequestBody Character character) {
        return characterservice.createCharacter(character);
    }

    @Operation(summary = "Update character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Character updated successfully"),
            @ApiResponse(responseCode = "404", description = "Character not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable(value = "id") int characterId,
                                           @Valid @RequestBody Character characterDetails) throws ResourceNotFoundException {
        final Character updatedCharacter = characterservice.updateCharacter(characterId, characterDetails);
        return ResponseEntity.ok(updatedCharacter);
    }

    @Operation(summary = "Delete character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Character deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Character not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteCharacter(@PathVariable(value = "id") int characterId) throws ResourceNotFoundException {
        characterservice.deleteCharacter(characterId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
