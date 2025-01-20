package es.system.ismaeljos.springboot.soap.service;

import java.util.List;

import es.system.ismaeljos.springboot.soap.service.interfaces.UserServiceSoapInterface;
import org.springframework.beans.factory.annotation.Autowired;

import es.system.ismaeljos.springboot.model.User;
import es.system.ismaeljos.springboot.service.interfaces.UserServiceInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.UserServiceSoapInterface")
public class UserServiceSoapImpl implements UserServiceSoapInterface {
    private UserServiceInterface userService;

    @Autowired
    public void setUserRepository(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        try {
            return userService.getUserById(userId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el usuario", e);
        }
    }

    @Override
    public boolean deleteById(int userId) {
        try{
            userService.deleteUser(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createUser(User user) {
        try{
            userService.createUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(int userId, User user) {
        try{
            userService.updateUser(userId, user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
