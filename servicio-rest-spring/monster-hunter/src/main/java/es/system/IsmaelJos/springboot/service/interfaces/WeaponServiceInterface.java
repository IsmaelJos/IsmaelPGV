package es.system.IsmaelJos.springboot.service.interfaces;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Weapon;

import java.util.List;

public interface WeaponServiceInterface {
    List<Weapon> getAllWeapons();
    Weapon getWeaponById(int WeaponId) throws ResourceNotFoundException;
    public Weapon createWeapon(Weapon weapon);
    Weapon updateWeapon(int weaponId, Weapon weaponDetails) throws ResourceNotFoundException;
    void deleteWeapon(int weaponId) throws ResourceNotFoundException;
}