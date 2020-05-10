package infocare.dao;

import infocare.entity.Tip;
import infocare.util.DBUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class TipDao {
	public boolean add(Tip tip) {
		DBUtil db = new DBUtil();
		String sql = "insert into tip(start, end, content) values(?,?,?)";
		Object[] params = {tip.getStart(), tip.getEnd(), tip.getContent()};
		int rowNum = db.doUpdate(sql, params);
		db.close();
		return rowNum == 1;
	}
	public boolean delete(int id) {
		DBUtil db = new DBUtil();
		String sql = "delete from tip where id = ?";
		Object[] params = {id};
		int rowNum = db.doUpdate(sql, params);
		db.close();
		return rowNum == 1;
	}

	public List<Tip> findAll() {
		DBUtil db = new DBUtil();
		String sql = "select * from tip order by id";
		List<Tip> list = null;
		try {
			ResultSet rs = db.doQuery(sql);
			if (rs != null) {
				list = new LinkedList<>();
				while (rs.next()) {
					int id = rs.getInt("tip.id");
					Date start = rs.getDate("tip.start");
					Date end = rs.getDate("tip.start");
					String content = rs.getString("tip.content");

					Tip tip = new Tip(id, start, end, content);
					list.add(tip);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return list;
	}
}
