package com.spring.player.service;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.player.dao.PlayerDAO;
import com.spring.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDao;
	
	
	public PlayerServiceImpl() {
	}

	@Override
	public List<Player> allPlayers() {
		// begain
		return playerDao.getPlayers();
		// commit
	}

	@Override
	public void savePlayer(Player player) {
		playerDao.addPlayers(player);
	}

	@Override
	public Player showPlayer(int id) {
		return playerDao.getPlayer(id);
	}

	@Override
	public int deletePlayer(int id) {
		return playerDao.removePlayer(id);
		
	}

}
