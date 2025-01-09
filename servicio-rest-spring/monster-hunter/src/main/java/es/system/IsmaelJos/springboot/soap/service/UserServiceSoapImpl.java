package es.system.IsmaelJos.springboot.soap.service;

import es.system.IsmaelJos.springboot.model.User;
import es.system.IsmaelJos.springboot.service.interfaces.UserServiceInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.IsmaelJos.springboot.soap.service.UserServiceSoapInterface")
public class UserServiceSoapImpl implements UserServiceSoapInterface{
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
    public boolean setUser(User user) {
        return false;
    }
}
