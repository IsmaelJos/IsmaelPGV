package es.system.ismaeljos.springboot.service.interfaces;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Roll;

import java.util.List;

public interface RollServiceInterface {
    List<Roll> getAllRolls();
    Roll getRollById(int rollId) throws ResourceNotFoundException;
    public Roll createRoll(Roll roll);
    Roll updateRoll(int rollId, Roll rollDetails) throws ResourceNotFoundException;
    void deleteRoll(int rollId) throws ResourceNotFoundException;
}
