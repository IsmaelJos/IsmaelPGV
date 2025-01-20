package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Armor;
import es.system.ismaeljos.springboot.model.Armor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "springboot.soap.service")
public interface ArmorServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="armor")
    List<Armor> getAllArmors();

    @WebMethod
    Armor getArmorById(@WebParam(name = "armorId") int armorId);

    @WebMethod
    boolean deleteById(@WebParam(name = "armorId") int armorId);

    @WebMethod
    boolean createArmor(@WebParam(name = "armorCreated") Armor armor);

    @WebMethod
    boolean updateArmor(@WebParam(name = "armorUpdated") int armorId, Armor armor);
}
