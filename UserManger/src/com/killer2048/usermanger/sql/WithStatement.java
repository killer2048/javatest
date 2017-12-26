package com.killer2048.usermanger.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.killer2048.usermanger.Main;

public class WithStatement {
	public static ResultSet query(String sql) throws SQLException {
		return Main.getInstance().getStatement().executeQuery(sql);
	}
	public static int update(String sql) throws SQLException {
		return Main.getInstance().getStatement().executeUpdate(sql);
	}
}
