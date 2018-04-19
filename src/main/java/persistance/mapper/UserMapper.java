package persistance.mapper;

import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistance.DBconfig;
import persistance.VirtualUser;
import user.User;

public class UserMapper {

	//Attributes
	private static int currentId;
	private static HashMap<Integer, WeakReference<User>> map = new HashMap<Integer, WeakReference<User>>();

	private static UserMapper instance;

	//Constructor
	public UserMapper() throws ClassNotFoundException, SQLException {
		currentId = this.getCurrentId();
	}

	//Methods
	public static UserMapper getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new UserMapper();
		return instance;
	}

	public int getCurrentId() throws ClassNotFoundException, SQLException {
		String query = "select max(id_user) from user_miagebook";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1)+1;
		}
		ps.close();
		rs.close();
		return 1;
	}

	public void insert(User u) throws ClassNotFoundException, SQLException {
		String query = "insert into user_miagebook values (?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		u.setId_user(currentId);
		currentId++;
		ps.setInt(1, u.getId_user());
		ps.setString(2, u.getPseudo());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getEmail());
		ps.executeUpdate();
		map.put(u.getId_user(), new WeakReference<User>(u));
		ps.close();
	}

	public User findById(int id) throws SQLException, ClassNotFoundException {
		if (map.get(id) != null)
			return map.get(id).get();
		String query = "select * from user_miagebook where id_user = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String pseudo = rs.getString("pseudo");
			String email = rs.getString("email");
			User u = new VirtualUser();
			u.setId_user(id);
			u.setPseudo(pseudo);
			u.setEmail(email);
			map.put(id, new WeakReference<User>(u));
			return u;
		}
		ps.close();
		rs.close();
		return null;	
	}
	
	public String findPasswordById(int id) throws SQLException, ClassNotFoundException {
		if (map.get(id) != null)
			return map.get(id).get().getPassword();
		String query = "select mdp from user_miagebook where id_user = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String password = rs.getString("mdp");
			return password;
		}
		ps.close();
		rs.close();
		return null;	
	}
	
	public List<User> findFriendsById(int id) throws SQLException, ClassNotFoundException {
		return null;
	}

	public void update(User u) {
		// TODO Auto-generated method stub
	}

}
