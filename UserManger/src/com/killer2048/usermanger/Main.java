package com.killer2048.usermanger;

import java.sql.*;
import java.util.*;

import com.killer2048.usermanger.login.Login;
import com.killer2048.usermanger.sql.WithStatement;
import com.killer2048.usermanger.user.*;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class Main {
//主功能类
	public static final int USERLEVEL = 1;//注册时的默认权限
	//jdbc对象
	public  UserI curruser;
	private  Connection conn;
	private Statement st;
	private  Map<Integer,String> rightList;
	private static Main m = new Main();
	
	private Main() {
		
	}
	public static Main getInstance() {
		return m;
	}
	
	public Connection getConn() {
		return conn;
	}
	public Statement getStatement() {
		return st;
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
		
//		Main.getInstance().test();
	}
	
	public void run() {
		//运行程序
		getOperation();
	}
	
	
	private void showMenu() {
		//显示主菜单
		System.out.println("欢迎使用用户管理系统");
		Tools.horizontalLine();
		System.out.println("用户登录-----------------------1");
		System.out.println("用户注册-----------------------2");
		System.out.println("程序退出-----------------------3");
	}
	private void getOperation() {
		Login lg = new Login();
		while(true) {
			//循环，主菜单选择
			showMenu();
			int input = Input.getInt();
			switch (input) {
			case 1:
				try {
					curruser = lg.login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("程序错误");
					curruser=null;
				}
				if(curruser!=null) {
					//登录成功
					System.out.println("登录成功");
					lg.loginSuccess(curruser);
				} else {
					System.out.println("用户名或密码错误");
				}
				break;
			case 2:
				boolean success=false;
				try {
					success = lg.regist();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("程序错误");
				}
				if(success) {
					System.out.println("注册成功");
				} else {
					System.out.println("注册失败");
				}
				break;
			case 3:
				//TODO:退出？注销？
				//注销
				exit();
			default:
				Input.wrongInput();
			}
			//主循环一圈结束注销用户（该用户的所有操作完成，回到登录）
			Main.getInstance().logout();
		}
	}
	
	public void init() throws ClassNotFoundException, SQLException {
		//启动初始化
		//数据库对象
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		st = conn.createStatement();
		//获取权限列表
		ResultSet rt = WithStatement.query("select id,text from rights");
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
	
	
	/*调试用*/
	public void test() {
		System.out.println(Input.rightsString(rightList,2));;
		
	}

	
	/*调试用 end*/
	public void exit() {
		if(st != null) {
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
	
//	public ResultSet query(String sql) throws SQLException {
//		return st.executeQuery(sql);
//		 
//	}
//	public ResultSet query(PreparedStatement sql) throws SQLException {
//		return sql.executeQuery();
//		 
//	}
//	
//	public int update(String sql) throws SQLException {
//		return st.executeUpdate(sql);
//	}
//	
//	public int update(PreparedStatement sql) throws SQLException {
//		return sql.executeUpdate();
//	}
	
	
}
