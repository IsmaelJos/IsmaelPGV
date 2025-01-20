package es.system.ismaeljos.springboot.service.interfaces;

import java.util.List;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Weapon;

public interface WeaponServiceInterface {
    List<Weapon> getAllWeapons();
    Weapon getWeaponById(int WeaponId) throws ResourceNotFoundException;
    public Weapon createWeapon(Weapon weapon);
    Weapon updateWeapon(int weaponId, Weapon weaponDetails) throws ResourceNotFoundException;
    void deleteWeapon(int weaponId) throws ResourceNotFoundException;
}