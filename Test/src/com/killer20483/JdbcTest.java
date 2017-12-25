package com.killer20483;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//在内存中加载oracle驱动(需要先注册驱动)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		//sql语句对象
		/*
		 * 在默认情况下，同一时间每个 Statement 对象在只能打开一个 ResultSet 对象。
		 * 因此，如果读取一个 ResultSet 对象与读取另一个交叉，
		 * 则这两个对象必须是由不同的 Statement 对象生成的。
		 * 如果存在某个语句的打开的当前 ResultSet 对象，
		 * 则 Statement 接口中的所有执行方法都会隐式关闭它。
		 * */
		Statement stat = conn.createStatement();
		//获取到查询的结果集
		ResultSet rs = stat.executeQuery("select ename from emp where empno=7369");
		while(rs.next()) {
			//getString(列名|列序号)
			System.out.println(rs.getString(1));
			System.out.println(rs.getString("ename"));
			
		}
		stat.close();
		conn.close();
		
	}
}
