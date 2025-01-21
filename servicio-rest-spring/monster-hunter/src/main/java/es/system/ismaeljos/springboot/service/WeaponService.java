package es.system.ismaeljos.springboot.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Weapon;
import es.system.ismaeljos.springboot.repository.WeaponRepository;

import java.util.List;

@Component
public class WeaponService implements es.system.ismaeljos.springboot.service.interfaces.WeaponServiceInterface {

    private WeaponRepository weaponRepository;

    @Autowired
    public void setWeaponRepository(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    @Override
    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }

    public Weapon getWeaponById(@PathVariable(value = "id") int weaponId) throws ResourceNotFoundException {
        return weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found for this id :: " + weaponId));
    }

    public Weapon createWeapon(@Valid @RequestBody Weapon weapon) {
        return weaponRepository.save(weapon);
    }


    public Weapon updateWeapon(@PathVariable(value = "id") int weaponId,
                                 @Valid @RequestBody Weapon weaponDetails) throws ResourceNotFoundException {
        Weapon weapon = weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found for this id :: " + weaponId));

        weapon.setName(weaponDetails.getName());
        weapon.setPower(weaponDetails.getPower());
        return weaponRepository.save(weapon);
    }


    public void deleteWeapon(@PathVariable(value = "id") int weaponId) throws ResourceNotFoundException {
        Weapon weapon = weaponRepository.findById(weaponId)
                .orElseThrow(() -> new ResourceNotFoundException("Weapon not found for this id :: " + weaponId));

        weaponRepository.delete(weapon);
    }
}

