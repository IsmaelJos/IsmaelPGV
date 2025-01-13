package es.system.ismaeljos.springboot.service.interfaces;

import java.util.List;

import es.system.ismaeljos.springboot.exception.ResourceNotFoundException;
import es.system.ismaeljos.springboot.model.User;

public interface UserServiceInterface {
    List<User> getAllUsers();
    User getUserById(int userId) throws ResourceNotFoundException;
    public User createUser(User user);
    User updateUser(int userId, User userDetails) throws ResourceNotFoundException;
    void deleteUser(int userId) throws ResourceNotFoundException;
}
