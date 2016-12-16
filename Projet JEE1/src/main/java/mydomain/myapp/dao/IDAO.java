package mydomain.myapp.dao;

import java.util.List;

import mydomain.myapp.entities.Player;

public interface IDAO {

	public List<Player> getAllPlayers();
	public Player createPlayer(Player player);
	public Player getPlayer(int playerID);
	public void deletePlayer(Player player);
	
}
