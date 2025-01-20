package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Element;
import es.system.ismaeljos.springboot.service.interfaces.ElementServiceInterface;
import es.system.ismaeljos.springboot.soap.service.interfaces.ElementServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.ElementServiceSoapInterface")
public class ElementServiceSoapImpl implements ElementServiceSoapInterface {
    private ElementServiceInterface elementService;

    @Autowired
    public void setElementRepository(ElementServiceInterface elementService) {
        this.elementService = elementService;
    }

    @Override
    public List<Element> getAllElements() {
        return elementService.getAllElements();
    }

    @Override
    public Element getElementById(int elementId) {
        try {
            return elementService.getElementById(elementId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el elemento", e);
        }
    }

    @Override
    public boolean deleteById(int elementId) {
        try{
            elementService.deleteElement(elementId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean createElement(Element element) {
        try{
            elementService.createElement(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateElement(int elementId, Element element) {
        try{
            elementService.updateElement(elementId, element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
