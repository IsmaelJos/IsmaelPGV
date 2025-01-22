package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Roll;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;
@WebService(targetNamespace = "springboot.soap.service")
public interface RollServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="roll")
    List<Roll> getAllRolls();

    @WebMethod
    Roll getRollById(@WebParam(name = "rollId") int rollId);

    @WebMethod
    boolean deleteById(@WebParam(name = "rollId") int rollId);

    @WebMethod
    boolean createRoll(@WebParam(name = "rollCreated") Roll roll);

    @WebMethod
    boolean updateRoll(@WebParam(name = "rollUpdated") int rollId, Roll roll);
}
