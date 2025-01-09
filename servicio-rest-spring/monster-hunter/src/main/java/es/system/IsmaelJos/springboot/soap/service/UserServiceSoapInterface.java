package es.system.IsmaelJos.springboot.soap.service;

import es.system.IsmaelJos.springboot.model.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;

import java.util.List;

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
    boolean setUser(@WebParam(name = "userCreated") User user);
}
