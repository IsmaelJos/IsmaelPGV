package es.system.ismaeljos.springboot.controller;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Rol;
import es.system.ismaeljos.springboot.service.interfaces.RolServiceInterface;
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
@RequestMapping("/api/v1/rols")
public class RolsController {
    private RolServiceInterface rolService;

    @Autowired
    public void setRolRepository(RolServiceInterface rolService) {
        this.rolService = rolService;
    }


    @Operation(summary = "Get all rols")
    @GetMapping("/")
    public List<Rol> getAllRols() {
        return rolService.getAllRols();
    }

    @Operation(summary = "Get rol by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Rol not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        Rol rol = rolService.getRolById(rolId);
        return ResponseEntity.ok().body(rol);
    }

    @Operation(summary = "Insert rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Rol createRol(@Valid @RequestBody Rol rol) {
        return rolService.createRol(rol);
    }

    @Operation(summary = "Update rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol updated successfully"),
            @ApiResponse(responseCode = "404", description = "Rol not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable(value = "id") int rolId,
                                           @Valid @RequestBody Rol rolDetails) throws ResourceNotFoundException {
        final Rol updatedRol = rolService.updateRol(rolId, rolDetails);
        return ResponseEntity.ok(updatedRol);
    }

    @Operation(summary = "Delete rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Rol not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteRol(@PathVariable(value = "id") int rolId) throws ResourceNotFoundException {
        rolService.deleteRol(rolId); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
