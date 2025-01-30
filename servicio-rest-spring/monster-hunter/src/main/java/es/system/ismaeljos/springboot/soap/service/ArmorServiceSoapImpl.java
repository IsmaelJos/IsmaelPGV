package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Armor;
import es.system.ismaeljos.springboot.service.interfaces.ArmorServiceInterface;
import es.system.ismaeljos.springboot.soap.service.interfaces.ArmorServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.ArmorServiceSoapInterface")
public class ArmorServiceSoapImpl implements ArmorServiceSoapInterface {
    private ArmorServiceInterface armorService;

    @Autowired
    public void setArmorRepository(ArmorServiceInterface armorService) {
        this.armorService = armorService;
    }

    @Override
    public List<Armor> getAllArmors() {
        return armorService.getAllArmors();
    }

    @Override
    public Armor getArmorById(int armorId) {
        try {
            return armorService.getArmorById(armorId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo la armadura", e);
        }
    }

    @Override
    public boolean deleteById(int armorId) {
        try{
            armorService.deleteArmor(armorId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createArmor(Armor armor) {
        try{
            armorService.createArmor(armor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateArmor(int armorId, Armor armor) {
        try{
            armorService.updateArmor(armorId, armor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
