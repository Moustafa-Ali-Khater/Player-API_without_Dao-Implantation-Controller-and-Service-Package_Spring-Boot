package com.spring.player.controller;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// http://localhost:8080

@RestController
@RequestMapping("/myapi")
// http://localhost:8080/api/agents
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // http://localhost:8080/api/myplayers
    @GetMapping("/myplayers")
    public List<Player> getPlayers(){
        return playerService.allPlayers();
    }

    // http://localhost:8080/api/players/id
    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable("id")int id) {
        Player p = playerService.showPlayer(id); //  //
        if(p == null) {
            throw new RuntimeException("Player Not Found id: " + id);
        }
        return p;
    }


    // http://localhost:8080/api/players
    @PostMapping("/players")
    public String savaPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return "Success Added";
    }

    // http://localhost:8080/api/players
    @PutMapping("/players")
    public String editPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return "Success editing";
    }

    @DeleteMapping("/players/{id}")
    public void removePlayer(@PathVariable("id")int id) {
        playerService.deletePlayer(id);
    }

    // http://localhost:8080/api/agents/agent?name=
    @GetMapping("/agent")
    public Player getPlayer(@RequestParam String name){
        return playerService.getPlayerByName(name);
    }
}
