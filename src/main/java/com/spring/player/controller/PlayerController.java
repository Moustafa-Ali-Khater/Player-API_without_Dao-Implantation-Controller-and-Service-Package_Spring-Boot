package com.spring.player.controller;

import java.util.List;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/
@RestController
@RequestMapping("/api")
// http://localhost:8080/api
public class PlayerController {
	
	
	private PlayerService playerService;

	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	// http://localhost:8080/api/players
	@GetMapping("/players")
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
	
	/*@GetMapping("/players")
	public Player getPlayerById(@RequestParam int id) {
		return playerService.showPlayer(id);
	}*/


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
	public String removePlayer(@PathVariable("id")int id) {
		int result = playerService.deletePlayer(id);
		if(result == 0) {
			throw new RuntimeException("Player Not Found id: " + id);
		}
		return "Success Remove !";
	}
	/*@DeleteMapping("/players")
	public void removePlayer(@RequestParam int id) {
		playerService.deletePlayer(id);
	}*/
		
}
