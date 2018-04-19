package user;

import java.util.ArrayList;
import java.util.List;

import utils.Observable;
import utils.Visiteur;

public class User extends Observable {

	protected int id_user;
	protected String pseudo;
	protected String password;
	protected String email;
	protected List<User> liste_amis;
		
	public User(){
		
	}
	
	public User(String pseudo) {
		this.pseudo = pseudo;
		this.password = "";
		this.setListe_amis(new ArrayList<User>());
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<User> getListe_amis() {
		return liste_amis;
	}

	public void setListe_amis(List<User> liste_amis) {
		this.liste_amis = liste_amis;
	}

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}

}
