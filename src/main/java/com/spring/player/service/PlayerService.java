package com.spring.player.service;


import com.spring.player.dao.PlayerDAO;
import com.spring.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Player getPlayerByName(String playerName){
        return playerDAO.findByName(playerName);
    }
}
