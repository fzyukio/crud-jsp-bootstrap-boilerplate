package infocare.util;

import java.sql.*;

public class DBUtil {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Statement stmt = null;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/infotips?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		username = "infocare";
		password = "childcare";
	}

	public DBUtil() {
	}

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);

			if (conn == null) {
				System.out.println("Something is wrong, cannot get connection!");
			}

			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet doQuery(String sql, Object[] params) {
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet doQuery(String sql) {
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int doUpdate(String sql, Object[] params) {
		int n = 0;

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			n = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		return n;
	}

	public int doUpdate(String sql) {
		int n = 0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			n = stmt.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		return n;
	}

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

}
