package es.system.ismaeljos.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Monster;
import es.system.ismaeljos.springboot.service.interfaces.MonsterServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/monsters")
public class MonstersController {
    private MonsterServiceInterface monsterService;

    @Autowired
    public void setMonsterService(MonsterServiceInterface monsterService) {
        this.monsterService = monsterService;
    }

    @Operation(summary = "Get all monster")
    @GetMapping("/")
    public List<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @Operation(summary = "Get monster by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Monster not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable(value = "id") int monsterId) throws ResourceNotFoundException {
        Monster monster = monsterService.getMonsterById(monsterId);
        return ResponseEntity.ok().body(monster);
    }

    @Operation(summary = "Insert monster")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Monster created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Monster createMonster(@Valid @RequestBody Monster monster) {
        return monsterService.createMonster(monster);
    }


    @Operation(summary = "Update monster")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Monster updated successfully"),
            @ApiResponse(responseCode = "404", description = "Monster not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Monster> updateMonster(@PathVariable(value = "id") int monsterId,
                                           @Valid @RequestBody Monster monsterDetails) throws ResourceNotFoundException {
        final Monster updatedMonster = monsterService.updateMonster(monsterId, monsterDetails);
        return ResponseEntity.ok(updatedMonster);
    }

    @Operation(summary = "Delete monster")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Monster deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Monster not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteMonster(@PathVariable(value = "id") int monsterId) throws ResourceNotFoundException {
        monsterService.deleteMonster(monsterId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
