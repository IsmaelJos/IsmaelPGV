package es.system.ismaeljos.springboot.service.interfaces;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Rol;

import java.util.List;

public interface RolServiceInterface {
    List<Rol> getAllRols();
    Rol getRolById(int rolId) throws ResourceNotFoundException;
    public Rol createRol(Rol rol);
    Rol updateRol(int rolId, Rol rolDetails) throws ResourceNotFoundException;
    void deleteRol(int rolId) throws ResourceNotFoundException;
}
