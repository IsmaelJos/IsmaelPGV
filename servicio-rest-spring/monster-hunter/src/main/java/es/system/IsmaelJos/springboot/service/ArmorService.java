package es.system.IsmaelJos.springboot.service;

import es.system.IsmaelJos.springboot.exception.ResourceNotFoundException;
import es.system.IsmaelJos.springboot.model.Armor;
import es.system.IsmaelJos.springboot.repository.ArmorRepository;
import es.system.IsmaelJos.springboot.service.interfaces.ArmorServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ArmorService implements ArmorServiceInterface {

    private ArmorRepository armorRepository;

    @Autowired
    public void setArmorRepository(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }
    @Override
    public List<Armor> getAllArmors() {
        return armorRepository.findAll();
    }

    public Armor getArmorById(@PathVariable(value = "id") int armorId) throws ResourceNotFoundException {
        return armorRepository.findById(armorId)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + armorId));
    }

    public Armor createArmor(@Valid @RequestBody Armor armor) {
        return armorRepository.save(armor);
    }


    public Armor updateArmor(@PathVariable(value = "id") int armorId,
                                 @Valid @RequestBody Armor armorDetails) throws ResourceNotFoundException {
        Armor armor = armorRepository.findById(armorId)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + armorId));

        armor.setName(armorDetails.getName());
        armor.setDefence(armorDetails.getDefence());
        return armorRepository.save(armor);
    }


    public void deleteArmor(@PathVariable(value = "id") int armorId) throws ResourceNotFoundException {
        Armor armor = armorRepository.findById(armorId)
                .orElseThrow(() -> new ResourceNotFoundException("Armor not found for this id :: " + armorId));

        armorRepository.delete(armor);
    }
}
