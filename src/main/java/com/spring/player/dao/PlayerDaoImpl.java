package com.spring.player.dao;

import java.util.List;


import com.spring.player.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
public class PlayerDaoImpl implements PlayerDAO {

	
	private EntityManager entityManager;

	public PlayerDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Player> getPlayers() {
		// begain 
		Session session = entityManager.unwrap(Session.class);
		
		Query<Player> query = session.createQuery("from Player",Player.class);
		
		// commit
		return query.getResultList();
	}


	@Override
	public void addPlayers(Player player) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(player);
	}


	@Override
	public Player getPlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(Player.class, id);
	}


	@Override
	public int removePlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("delete from Player where id=?1");
		q.setInteger(1, id);
		
		return q.executeUpdate();  // 1    0
		
	}
	
}