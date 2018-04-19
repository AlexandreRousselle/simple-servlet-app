package persistance;

import java.sql.SQLException;

import persistance.mapper.UserMapper;
import user.User;
import utils.Visiteur;


public class VisiteurUpdate extends Visiteur {

	@Override
	public void visit(User u) {
		// TODO Auto-generated method stub
		try {
			UserMapper.getInstance().update(u);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
