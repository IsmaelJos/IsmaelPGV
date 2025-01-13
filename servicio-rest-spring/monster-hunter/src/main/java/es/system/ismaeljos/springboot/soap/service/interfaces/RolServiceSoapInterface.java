package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Rol;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;
@WebService(targetNamespace = "springboot.soap.service")
public interface RolServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="rol")
    List<Rol> getAllRols();

    @WebMethod
    Rol getRolById(@WebParam(name = "rolId") int rolId);

    @WebMethod
    boolean deleteById(@WebParam(name = "rolId") int rolId);

    @WebMethod
    boolean createRol(@WebParam(name = "rolCreated") Rol rol);

    @WebMethod
    boolean updateRol(@WebParam(name = "rolUpdated") int rolId, Rol rol);
}
