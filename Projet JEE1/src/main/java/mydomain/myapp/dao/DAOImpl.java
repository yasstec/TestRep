package mydomain.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mydomain.myapp.entities.Player;

public class DAOImpl implements IDAO{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Projet_JEE1");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();	
	@Override
	public List<Player> getAllPlayers() {

		Query query = em.createNamedQuery("findAllPlayers");
		return query.getResultList();
	}
	public DAOImpl() {
		super();
	}
	@Override
	public Player createPlayer(Player player) {
		try {
			tx.begin();
			em.persist(player);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return player;
	}
	@Override
	public Player getPlayer(int playerID) {
		return em.find(Player.class, playerID);
	}
	@Override
	public void deletePlayer(Player player) {
		try {
			tx.begin();
			em.remove(player);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
}
