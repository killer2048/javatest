package com.killer20483;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//���ڴ��м���oracle����(��Ҫ��ע������)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		//sql������
		/*
		 * ��Ĭ������£�ͬһʱ��ÿ�� Statement ������ֻ�ܴ�һ�� ResultSet ����
		 * ��ˣ������ȡһ�� ResultSet �������ȡ��һ�����棬
		 * ������������������ɲ�ͬ�� Statement �������ɵġ�
		 * �������ĳ�����Ĵ򿪵ĵ�ǰ ResultSet ����
		 * �� Statement �ӿ��е�����ִ�з���������ʽ�ر�����
		 * */
		Statement stat = conn.createStatement();
		//��ȡ����ѯ�Ľ����
		ResultSet rs = stat.executeQuery("select ename from emp where empno=7369");
		while(rs.next()) {
			//getString(����|�����)
			System.out.println(rs.getString(1));
			System.out.println(rs.getString("ename"));
			
		}
		stat.close();
		conn.close();
		
	}
}
