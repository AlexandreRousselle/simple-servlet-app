package authentification;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import persistance.VirtualUser;
import persistance.mapper.UserMapper;
import user.User;

public class RegisterForm {

	private String pseudo;
	private String password;
	private String email;
	
	public User register(HttpServletRequest request) {
		
		pseudo = getValeurChamp(request, "pseudo");
		password = getValeurChamp(request, "password");
		email = getValeurChamp(request, "email");
		
		User user = new VirtualUser();
		
		user.setPseudo(pseudo);
		user.setPassword(password);
		user.setEmail(email);
		
		try {
			UserMapper.getInstance().insert(user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
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
	
}
