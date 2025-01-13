package es.system.ismaeljos.springboot.service.interfaces;

import java.util.List;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Element;

public interface ElementServiceInterface {
    List<Element> getAllElements();
    Element getElementById(int ElementId) throws ResourceNotFoundException;
    public Element createElement(Element element);
    Element updateElement(int elementId, Element elementDetails) throws ResourceNotFoundException;
    void deleteElement(int elementId) throws ResourceNotFoundException;
}
