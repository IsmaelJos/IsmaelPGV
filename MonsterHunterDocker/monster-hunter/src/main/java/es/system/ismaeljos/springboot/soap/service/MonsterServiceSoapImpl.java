package es.system.ismaeljos.springboot.soap.service;

import es.system.ismaeljos.springboot.model.Monster;
import es.system.ismaeljos.springboot.service.interfaces.MonsterServiceInterface;
import es.system.ismaeljos.springboot.soap.service.interfaces.MonsterServiceSoapInterface;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@WebService(endpointInterface = "es.system.ismaeljos.springboot.soap.service.interfaces.MonsterServiceSoapInterface")
public class MonsterServiceSoapImpl implements MonsterServiceSoapInterface {
    private MonsterServiceInterface monsterService;

    @Autowired
    public void setMonsterRepository(MonsterServiceInterface monsterService) {
        this.monsterService = monsterService;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @Override
    public Monster getMonsterById(int monsterId) {
        try {
            return monsterService.getMonsterById(monsterId);
        } catch (Exception e) {
            throw new WebServiceException("Error obteniendo el Monstruo", e);
        }
    }

    @Override
    public boolean deleteById(int monsterId) {
        try{
            monsterService.deleteMonster(monsterId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean createMonster(Monster monster) {
        try{
            monsterService.createMonster(monster);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateMonster(int monsterId, Monster monster) {
        try{
            monsterService.updateMonster(monsterId, monster);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
