package es.system.ismaeljos.springboot.soap.service.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;

import java.util.List;

import es.system.ismaeljos.springboot.model.User;

public interface UserServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="user")
    List<User> getAllUsers();

    @WebMethod
    User getUserById(@WebParam(name = "userId") int userId);

    @WebMethod
    boolean deleteById(@WebParam(name = "userId") int userId);

    @WebMethod
    boolean createUser(@WebParam(name = "userCreated") User user);

    @WebMethod
    boolean updateUser(@WebParam(name = "userUpdated") int userId, User user);
}
