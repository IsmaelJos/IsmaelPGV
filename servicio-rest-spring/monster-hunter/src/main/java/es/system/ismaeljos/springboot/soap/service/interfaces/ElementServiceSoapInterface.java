package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Element;
import es.system.ismaeljos.springboot.model.Element;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "springboot.soap.service")
public interface ElementServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="element")
    List<Element> getAllElements();

    @WebMethod
    Element getElementById(@WebParam(name = "elementId") int elementId);

    @WebMethod
    boolean deleteById(@WebParam(name = "elementId") int elementId);

    @WebMethod
    boolean createElement(@WebParam(name = "elementCreated") Element element);

    @WebMethod
    boolean updateElement(@WebParam(name = "elementUpdated") int elementId, Element element);
}
