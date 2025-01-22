package es.system.ismaeljos.springboot.controller;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Roll;
import es.system.ismaeljos.springboot.service.interfaces.RollServiceInterface;
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
@RequestMapping("/api/v1/rolls")
public class RollsController {
    private RollServiceInterface rollService;

    @Autowired
    public void setRollRepository(RollServiceInterface rollService) {
        this.rollService = rollService;
    }


    @Operation(summary = "Get all rolls")
    @GetMapping("/")
    public List<Roll> getAllRolls() {
        return rollService.getAllRolls();
    }

    @Operation(summary = "Get roll by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Roll not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Roll> getRollById(@PathVariable(value = "id") int rollId) throws ResourceNotFoundException {
        Roll roll = rollService.getRollById(rollId);
        return ResponseEntity.ok().body(roll);
    }

    @Operation(summary = "Insert roll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roll created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Roll createRoll(@Valid @RequestBody Roll roll) {
        return rollService.createRoll(roll);
    }

    @Operation(summary = "Update roll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roll updated successfully"),
            @ApiResponse(responseCode = "404", description = "Roll not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Roll> updateRoll(@PathVariable(value = "id") int rollId,
                                          @Valid @RequestBody Roll rollDetails) throws ResourceNotFoundException {
        final Roll updatedRoll = rollService.updateRoll(rollId, rollDetails);
        return ResponseEntity.ok(updatedRoll);
    }

    @Operation(summary = "Delete roll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roll deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Roll not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteRoll(@PathVariable(value = "id") int rollId) throws ResourceNotFoundException {
        rollService.deleteRoll(rollId); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
