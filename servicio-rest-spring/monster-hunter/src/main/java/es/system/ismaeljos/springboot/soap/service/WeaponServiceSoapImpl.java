package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Weapon;
import es.system.ismaeljos.springboot.service.WeaponService;
import es.system.ismaeljos.springboot.soap.service.interfaces.WeaponServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.WeaponServiceSoapInterface")
public class WeaponServiceSoapImpl implements WeaponServiceSoapInterface {
    private WeaponService weaponService;

    @Autowired
    public void setWeaponRepository(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @Override
    public List<Weapon> getAllWeapons() {
        return weaponService.getAllWeapons();
    }

    @Override
    public Weapon getWeaponById(int weaponId) {
        try {
            return weaponService.getWeaponById(weaponId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el arma", e);
        }
    }

    @Override
    public boolean deleteById(int weaponId) {
        try{
            weaponService.deleteWeapon(weaponId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createWeapon(Weapon weapon) {
        try{
            weaponService.createWeapon(weapon);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateWeapon(int weaponId, Weapon weapon) {
        try{
            weaponService.updateWeapon(weaponId, weapon);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
