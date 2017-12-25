package com.killer2048.usermanger;

import java.sql.*;
import java.util.*;
import com.killer2048.usermanger.user.*;
import com.killer2048.usermanger.util.Tools;

public class Main {
//主功能类
	//jdbc对象
	public  Scanner sc;
	public  User curruser;
	private  Connection conn;
	private  Statement st;
	private  Map<Integer,String> rightList;
	private static Main m = new Main();
	
	private Main() {
		
	}
	public static Main getInstance() {
		return m;
	}
	
	public Map<Integer, String> getRightList() {
		return rightList;
	}
	public static void main(String[] args) {
		try {
			Main.getInstance().init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("程序文件缺失");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("初始化失败，退出");
			System.exit(1);
		}
		Main.getInstance().run();
		
		Main.getInstance().test();
	}
	
	public void run() {
		//运行程序
		while(true) {
			//主循环
			
			
			//主循环一圈结束注销用户（该用户的所有操作完成，回到登录）
			Main.getInstance().logout();
		}
	}
	
	
	public void init() throws ClassNotFoundException, SQLException {
		//启动初始化
		//数据库对象
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		sc = new Scanner(System.in);
		st = conn.createStatement();
		//获取权限列表
		ResultSet rt = query("select id,text from rights");
		Map<Integer,String> rlist = new HashMap<>();
		while(rt.next()) {
			rlist.put(Integer.valueOf(rt.getString("id")),rt.getString("text"));
		}
		rightList=rlist;
		
		
	}
	public void logout() {
//		当前用户注销
		curruser=null;
	}
	public void mainMenu() {
		System.out.println("欢迎使用用户管理系统");
		Tools.horizontalLine();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public void test() {
		Tools.horizontalLine();
		System.out.println("修改自己的信息 -----------------1");
		System.out.println("查询自己的信息 -----------------2");
		System.out.println("程序退出-----------------------1");
		System.out.println(changeInfoSql("ddd","fdfa' where i=1 --sf@dsfadf.dfas","hehe"));
		
		
		
	}
	
	public static String changeInfoSql(String name,String email,String pw) {
		StringBuilder sb = new StringBuilder();
		sb.append("update users set name='");
		sb.append(name);
		sb.append("',email='");
		sb.append(email);
		sb.append("',password='");
		sb.append(pw);
		sb.append("' where id=");
		sb.append(100);
		return sb.toString();
	}
	
	public void exit() {
		if(sc!=null) {
			sc.close();
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("程序已退出");
		System.exit(0);
	}
	
	public ResultSet query(String sql) throws SQLException {
		return st.executeQuery(sql);
		 
	}
	
	public int update(String sql) throws SQLException {
		return st.executeUpdate(sql);
	}
	
	
}
