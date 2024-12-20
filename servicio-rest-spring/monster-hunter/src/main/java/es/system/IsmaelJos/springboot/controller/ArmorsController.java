package es.system.IsmaelJos.springboot.controller;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Armor;
import es.system.IsmaelJos.springboot.service.interfaces.ArmorServiceInterface;
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
@RequestMapping("/api/v1/armors")
public class ArmorsController {
    private ArmorServiceInterface armorService;

    @Autowired
    public void setArmorRepository(ArmorServiceInterface armorService) {
        this.armorService = armorService;
    }


    @Operation(summary = "Get all armors")
    @GetMapping("/")
    public List<Armor> getAllArmors() {
        return armorService.getAllArmors();
    }

    @Operation(summary = "Get armor by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Armor not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Armor> getArmorById(@PathVariable(value = "id") int armorId) throws ResourceNotFoundException {
        Armor armor = armorService.getArmorById(armorId);
        return ResponseEntity.ok().body(armor);
    }

    @Operation(summary = "Insert armor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Armor created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Armor createArmor(@Valid @RequestBody Armor armor) {
        return armorService.createArmor(armor);
    }

    @Operation(summary = "Update armor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Armor updated successfully"),
            @ApiResponse(responseCode = "404", description = "Armor not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Armor> updateArmor(@PathVariable(value = "id") int armorId,
                                           @Valid @RequestBody Armor armorDetails) throws ResourceNotFoundException {
        final Armor updatedArmor = armorService.updateArmor(armorId, armorDetails);
        return ResponseEntity.ok(updatedArmor);
    }

    @Operation(summary = "Delete armor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Armor deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Armor not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteArmor(@PathVariable(value = "id") int armorId) throws ResourceNotFoundException {
        armorService.deleteArmor(armorId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
