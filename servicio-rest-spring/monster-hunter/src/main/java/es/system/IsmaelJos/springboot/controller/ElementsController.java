package es.system.IsmaelJos.springboot.controller;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Element;
import es.system.IsmaelJos.springboot.service.interfaces.ElementServiceInterface;
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
@RequestMapping("/api/v1/elements")
public class ElementsController {
    private ElementServiceInterface elementService;

    @Autowired
    public void setElementRepository(ElementServiceInterface elementService) {
        this.elementService = elementService;
    }


    @Operation(summary = "Get all elements")
    @GetMapping("/")
    public List<Element> getAllElements() {
        return elementService.getAllElements();
    }

    @Operation(summary = "Get element by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Element not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Element> getUElementById(@PathVariable(value = "id") int elementId) throws ResourceNotFoundException {
        Element element = elementService.getElementById(elementId);
        return ResponseEntity.ok().body(element);
    }

    @Operation(summary = "Insert element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Element created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Element createElement(@Valid @RequestBody Element element) {
        return elementService.createElement(element);
    }

    @Operation(summary = "Update element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Element updated successfully"),
            @ApiResponse(responseCode = "404", description = "Element not found")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Element> updateElement(@PathVariable(value = "id") int elementId,
                                           @Valid @RequestBody Element elementDetails) throws ResourceNotFoundException {
        final Element updatedElement = elementService.updateElement(elementId, elementDetails);
        return ResponseEntity.ok(updatedElement);
    }

    @Operation(summary = "Delete element")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Element deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Element not found")
    })
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteElement(@PathVariable(value = "id") int elementId) throws ResourceNotFoundException {
        elementService.deleteElement(elementId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}