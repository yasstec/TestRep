package mydomain.myapp.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Null;

import mydomain.myapp.dao.DAOImpl;
import mydomain.myapp.dao.IDAO;
import mydomain.myapp.entities.*;
@ManagedBean
@RequestScoped
public class PlayerController implements Serializable { 
    private static final long serialVersionUID = 1L;

	List<Player> playerList = new ArrayList<Player>();
	private Player player = new Player();
	private IDAO dao = new DAOImpl();
	
	 public String addNewPlayer(){

		 		if(player.getNom()!=null){
		 			System.out.println("Nom: " +player.getNom());
		 		}
				 player = dao.createPlayer(player);
				 playerList = dao.getAllPlayers();
				   FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
			       FacesContext.getCurrentInstance().addMessage( null, message );
		 	
		 //player=new Player();
		 return "index.xhtml";
}
	 
	public List<Player> getPlayerList() {
		playerList = dao.getAllPlayers();
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player Player) {
		this.player = Player;
	}

	public List<Player> getList() {
		return playerList;
	}

	public void setList(List<Player> list) {
		this.playerList = list;
	}
	
	public PlayerController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String editAction(Player player) {
		player.setEditable(true);
		return null;
	}
	
	public String deleteAction(Player player) {
		dao.deletePlayer(player);
		return null;
	}
	public String saveChange() {
		for (Player player_new : playerList){
			if(player_new.isEditable()){
				dao.createPlayer(player_new);	
			}			
			player_new.setEditable(false);
		}
		return "index.xhtml";
	}
	public String resetChange() {
		for (Player player : playerList){
			player.setEditable(false);
		}
		return null;
	}
}
