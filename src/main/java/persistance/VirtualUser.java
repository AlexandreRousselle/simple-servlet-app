package persistance;

import java.sql.SQLException;
import java.util.List;

import persistance.mapper.UserMapper;
import user.User;

public class VirtualUser extends User {

	public VirtualUser() {
		super();
		this.liste_amis = null;	
	}

	@Override
	public String getPassword() {
		if (this.password == null){
			try {
				this.password = UserMapper.getInstance().findPasswordById(this.id_user);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.password;
	}
	
	@Override
	public List<User> getListe_amis() {
		if (this.liste_amis == null){
			try {
				this.liste_amis = UserMapper.getInstance().findFriendsById(this.id_user);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.liste_amis;
	}
	
}
