package es.system.ismaeljos.springboot.service;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.Roll;
import es.system.ismaeljos.springboot.repository.RollRepository;
import es.system.ismaeljos.springboot.service.interfaces.RollServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class RollService implements RollServiceInterface {

    private RollRepository rollRepository;

    @Autowired
    public void setRollRepository(RollRepository rollRepository) {
        this.rollRepository = rollRepository;
    }

    public List<Roll> getAllRolls() {
        return rollRepository.findAll();
    }

    public Roll getRollById(@PathVariable(value = "id") int rollId) throws ResourceNotFoundException {
        return rollRepository.findById(rollId)
                .orElseThrow(() -> new ResourceNotFoundException("Roll not found for this id :: " + rollId));
    }

    public Roll createRoll(@Valid @RequestBody Roll roll) {
        return rollRepository.save(roll);
    }

    public Roll updateRoll(@PathVariable(value = "id") int rollId,
                          @Valid @RequestBody Roll rollDetails) throws ResourceNotFoundException {
        Roll roll = rollRepository.findById(rollId)
                .orElseThrow(() -> new ResourceNotFoundException("Roll not found for this id :: " + rollId));

        roll.setName(rollDetails.getName());
        return rollRepository.save(roll);
    }

    public void deleteRoll(@PathVariable(value = "id") int rollId) throws ResourceNotFoundException {
        Roll roll = rollRepository.findById(rollId)
                .orElseThrow(() -> new ResourceNotFoundException("Roll not found for this id :: " + rollId));

        rollRepository.delete(roll);
    }
    
}
