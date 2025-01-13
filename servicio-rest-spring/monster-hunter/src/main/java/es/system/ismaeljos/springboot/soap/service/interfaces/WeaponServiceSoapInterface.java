package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Weapon;
import es.system.ismaeljos.springboot.model.Weapon;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "springboot.soap.service")
public interface WeaponServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="weapon")
    List<Weapon> getAllWeapons();

    @WebMethod
    Weapon getWeaponById(@WebParam(name = "weaponId") int weaponId);

    @WebMethod
    boolean deleteById(@WebParam(name = "weaponId") int weaponId);

    @WebMethod
    boolean createWeapon(@WebParam(name = "weaponCreated") Weapon weapon);

    @WebMethod
    boolean updateWeapon(@WebParam(name = "weaponUpdated") int weaponId, Weapon weapon);
}
