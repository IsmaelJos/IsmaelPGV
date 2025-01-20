package es.system.ismaeljos.springboot.soap.service.interfaces;

import es.system.ismaeljos.springboot.model.Monster;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;

import java.util.List;

import es.system.ismaeljos.springboot.model.Monster;
import jakarta.jws.WebService;

@WebService(targetNamespace = "springboot.soap.service")
public interface MonsterServiceSoapInterface {
    @WebMethod
    @WebResult(
            name="monster")
    List<Monster> getAllMonsters();

    @WebMethod
    Monster getMonsterById(@WebParam(name = "monsterId") int monsterId);

    @WebMethod
    boolean deleteById(@WebParam(name = "monsterId") int monsterId);

    @WebMethod
    boolean createMonster(@WebParam(name = "monsterCreated") Monster monster);

    @WebMethod
    boolean updateMonster(@WebParam(name = "monsterUpdated") int monsterId, Monster monster);
}
