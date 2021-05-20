package com.spring.player.controller;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080

@RestController
@RequestMapping("/api")
// http://localhost:8080/api/agents
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // http://localhost:8080/api/agents/agent?name=
    @GetMapping("/agent")
    public Player getPlayer(@RequestParam String name){
        return playerService.getPlayerByName(name);
    }
}
