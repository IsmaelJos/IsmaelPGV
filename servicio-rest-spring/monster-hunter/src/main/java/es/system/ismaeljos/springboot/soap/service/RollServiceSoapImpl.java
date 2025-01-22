package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Roll;
import es.system.ismaeljos.springboot.service.interfaces.RollServiceInterface;
import es.system.ismaeljos.springboot.soap.service.interfaces.RollServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.RollServiceSoapInterface")
public class RollServiceSoapImpl implements RollServiceSoapInterface {
    private RollServiceInterface rollService;

    @Autowired
    public void setRollRepository(RollServiceInterface rollService) {
        this.rollService = rollService;
    }

    @Override
    public List<Roll> getAllRolls() {
        return rollService.getAllRolls();
    }

    @Override
    public Roll getRollById(int rollId) {
        try {
            return rollService.getRollById(rollId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el usuario", e);
        }
    }

    @Override
    public boolean deleteById(int rollId) {
        try{
            rollService.deleteRoll(rollId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createRoll(Roll roll) {
        try{
            rollService.createRoll(roll);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateRoll(int rollId, Roll roll) {
        try{
            rollService.updateRoll(rollId, roll);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
