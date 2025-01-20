package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Rol;
import es.system.ismaeljos.springboot.service.interfaces.RolServiceInterface;
import es.system.ismaeljos.springboot.soap.service.interfaces.RolServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.RolServiceSoapInterface")
public class RolServiceSoapImpl implements RolServiceSoapInterface {
    private RolServiceInterface rolService;

    @Autowired
    public void setRolRepository(RolServiceInterface rolService) {
        this.rolService = rolService;
    }

    @Override
    public List<Rol> getAllRols() {
        return rolService.getAllRols();
    }

    @Override
    public Rol getRolById(int rolId) {
        try {
            return rolService.getRolById(rolId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el usuario", e);
        }
    }

    @Override
    public boolean deleteById(int rolId) {
        try{
            rolService.deleteRol(rolId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createRol(Rol rol) {
        try{
            rolService.createRol(rol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateRol(int rolId, Rol rol) {
        try{
            rolService.updateRol(rolId, rol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
