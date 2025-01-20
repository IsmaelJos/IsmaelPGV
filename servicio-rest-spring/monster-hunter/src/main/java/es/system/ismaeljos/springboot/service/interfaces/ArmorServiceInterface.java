package es.system.ismaeljos.springboot.service.interfaces;

import java.util.List;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Armor;

public interface ArmorServiceInterface {
    List<Armor> getAllArmors();
    Armor getArmorById(int ArmorId) throws ResourceNotFoundException;
    public Armor createArmor(Armor armor);
    Armor updateArmor(int armorId, Armor armorDetails) throws ResourceNotFoundException;
    void deleteArmor(int armorId) throws ResourceNotFoundException;
}
