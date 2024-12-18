package es.system.IsmaelJos.springboot.controller;

import es.system.IsmaelJos.springboot.model.Monster;
import es.system.IsmaelJos.springboot.model.User;
import es.system.IsmaelJos.springboot.service.MonsterServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monster")
public class MonsterController {
    MonsterServiceInterface monsterService;
    @Autowired
    public void setMonsterService(MonsterServiceInterface monsterService) {
        this.monsterService = monsterService;
    }

    @Operation(summary = "Get all monster")
    @GetMapping("/")
    public List<Monster> getAllUsers() {
        return monsterService.getAllMonsters();
    }

}
