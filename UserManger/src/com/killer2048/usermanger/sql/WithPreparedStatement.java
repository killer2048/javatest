package com.killer2048.usermanger.sql;

import java.sql.*;

public class WithPreparedStatement {
	private PreparedStatement sql;
	public WithPreparedStatement(PreparedStatement sql) {
		this.sql=sql;
	}
	
	
	public void set(int index,String value) throws SQLException {
		sql.setString(index, value);
	}
	public void set(int index,int value) throws SQLException {
		sql.setInt(index, value);
	}
	public void set(int index,Integer value) throws SQLException {
		sql.setInt(index, value.intValue());
	}
	public void set(int index,float value) throws SQLException {
		sql.setFloat(index, value);
	}
	public void set(int index,Float value) throws SQLException {
		sql.setFloat(index, value.floatValue());
	}
	public void set(int index,double value) throws SQLException {
		sql.setDouble(index, value);
	}
	public void set(int index,Double value) throws SQLException {
		sql.setDouble(index, value.doubleValue());
	}
	public void set(int index,long value) throws SQLException {
		sql.setLong(index, value);
	}
	public void set(int index,Long value) throws SQLException {
		sql.setLong(index, value.longValue());
	}
	public void set(int index,boolean value) throws SQLException {
		sql.setBoolean(index, value);
	}
	public void set(int index,Boolean value) throws SQLException {
		sql.setBoolean(index, value.booleanValue());
	}
	
	
//	public static void setAll(PreparedStatement sql,List lt) {
//		//todo:²»»á
//	}
//	
	public ResultSet query() throws SQLException {
		return sql.executeQuery();
	}
	public int update() throws SQLException {
		return sql.executeUpdate();
	}
	public void close() throws SQLException {
		sql.close();
	}
}
