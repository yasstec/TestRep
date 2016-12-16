package mydomain.myapp.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Test;
import junit.framework.TestCase;
import mydomain.myapp.entities.Player;

public class TestClasse extends TestCase {

	 @Test
	 public void TestCalculer() {
			
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Projet_JEE1");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();	
		Player player1= new Player("Ab", "Ya", "AC", 10);
		Player player2= new Player("MA", "NA", "MLD", 15);
			try {
				tx.begin();
				em.persist(player1);
				em.persist(player2);
				tx.commit();
				assertTrue(true);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				tx.rollback();
				assertTrue(e.getMessage(),false);
			}
	 
	 }
}
