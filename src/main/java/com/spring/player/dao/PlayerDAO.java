package com.spring.player.dao;

import com.spring.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@RepositoryRestResource(path = "persons")
public interface PlayerDAO extends JpaRepository<Player,Integer> {

    Player findByName(@RequestParam String name);

    List<Player> findByNameContaining(@RequestParam String name);
}

//   Player
/*
============> http://localhost:8080/api

Get      http://localhost:8080/api/players
Get      http://localhost:8080/api/players/id
Post     http://localhost:8080/api/players      body Player
Put      http://localhost:8080/api/players      body Player
Delete   http://localhost:8080/api/players/id
Get      http://localhost:8080/api/players/getbyName?name=
Get      http://localhost:8080/api/players/search/findByNameContaining?name=


* */