package com.kh.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "student";
	private final String PASSWORD = "student";

	private static JDBCTemplate instance;

	public JDBCTemplate() {
		try {
			Class.forName(DRIVER_NAME); // 반드시 해줘야되는 것
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// JDBCTemplate이 딱 한번만 생성되도록 하는 것
	public static JDBCTemplate getDriverLoad() {
		if (instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // 오토커밋해제
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 커밋
	public void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 롤백
	public void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}