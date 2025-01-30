package es.system.ismaeljos.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Element;
import es.system.ismaeljos.springboot.repository.ElementRepository;
import es.system.ismaeljos.springboot.service.interfaces.ElementServiceInterface;
import jakarta.validation.Valid;

@Component
@Transactional
public class ElementService implements ElementServiceInterface {

    private ElementRepository elementRepository;

    @Autowired
    public void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @Override
    public List<Element> getAllElements() {
        return elementRepository.findAll();
    }

    public Element getElementById(@PathVariable(value = "id") int elementId) throws ResourceNotFoundException {
        return elementRepository.findById(elementId)
                .orElseThrow(() -> new ResourceNotFoundException("Element not found for this id :: " + elementId));
    }

    public Element createElement(@Valid @RequestBody Element element) {
        return elementRepository.save(element);
    }


    public Element updateElement(@PathVariable(value = "id") int elementId,
                                 @Valid @RequestBody Element elementDetails) throws ResourceNotFoundException {
        Element element = elementRepository.findById(elementId)
                .orElseThrow(() -> new ResourceNotFoundException("Element not found for this id :: " + elementId));

        element.setName(elementDetails.getName());
        return elementRepository.save(element);
    }


    public void deleteElement(@PathVariable(value = "id") int elementId) throws ResourceNotFoundException {
        Element element = elementRepository.findById(elementId)
                .orElseThrow(() -> new ResourceNotFoundException("Element not found for this id :: " + elementId));

        elementRepository.delete(element);
    }
}
