package com.spring.player.dao;

import com.spring.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player,Integer> {

}

//   Player
/*
============> http://localhost:8080/api

Get      http://localhost:8080/api/players
Get      http://localhost:8080/api/players/id
Post     http://localhost:8080/api/players      body Player
Put      http://localhost:8080/api/players      body Player
Delete   http://localhost:8080/api/players/id


* */