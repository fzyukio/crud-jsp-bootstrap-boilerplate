package infocare.dao;

import infocare.entity.Tip;
import infocare.util.DBUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
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

	public List<Tip> findTips(String query, Object[] params) {
		DBUtil db = new DBUtil();
		List<Tip> list = null;
		try {
			ResultSet rs = db.doQuery(query, params);
			if (rs != null) {
				list = new LinkedList<>();
				while (rs.next()) {
					int id = rs.getInt("tip.id");
					Date start = rs.getDate("tip.start");
					Date end = rs.getDate("tip.end");
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

	public List<Tip> findTipsInEffectToday() {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		String sql = "select * from tip where start <= ? and end >= ? order by end, start";
		Object[] params = {today, today};
		return findTips(sql, params);
	}

	public List<Tip> findAll() {
		String sql = "select * from tip order by id";
		return findTips(sql, new Object[]{});
	}
}
