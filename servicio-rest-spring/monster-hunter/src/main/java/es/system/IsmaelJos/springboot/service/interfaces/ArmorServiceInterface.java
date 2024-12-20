package es.system.IsmaelJos.springboot.service.interfaces;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Armor;
import es.system.IsmaelJos.springboot.model.Element;

import java.util.List;

public interface ArmorServiceInterface {
    List<Armor> getAllArmors();
    Armor getArmorById(int ArmorId) throws ResourceNotFoundException;
    public Armor createArmor(Armor armor);
    Armor updateArmor(int armorId, Armor armorDetails) throws ResourceNotFoundException;
    void deleteArmor(int armorId) throws ResourceNotFoundException;
}
