package infocare.dao;

import infocare.entity.User;
import infocare.util.DBUtil;

import java.sql.ResultSet;

public class UserDao {

	public User get(String username, String password) {
		DBUtil db = new DBUtil();
		String sql = "select * from user where username = ?";
		Object[] params = {username};
		User retval = null;
		try {
			ResultSet rs = db.doQuery(sql, params);
			if (rs.next()) {
				String pass = rs.getString("user.password");
				if (pass.equals(password)) {
					String name = rs.getString("user.username");
					int id = rs.getInt("user.id");
					retval = new User(id, name, password);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return retval;
	}
}
