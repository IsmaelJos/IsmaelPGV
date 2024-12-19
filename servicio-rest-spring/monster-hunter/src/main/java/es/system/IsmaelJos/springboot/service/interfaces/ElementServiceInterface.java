package es.system.IsmaelJos.springboot.service.interfaces;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Element;

import java.util.List;

public interface ElementServiceInterface {
    List<Element> getAllElements();
    Element getElementById(int ElementId) throws ResourceNotFoundException;
    public Element createElement(Element element);
    Element updateElement(int elementId, Element elementDetails) throws ResourceNotFoundException;
    void deleteElement(int elementId) throws ResourceNotFoundException;
}
