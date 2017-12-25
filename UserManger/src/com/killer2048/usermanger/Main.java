package com.killer2048.usermanger;

import java.sql.*;
import java.util.*;

import com.killer2048.usermanger.login.Login;
import com.killer2048.usermanger.user.*;
import com.killer2048.usermanger.util.Input;
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
			Scanner sc = Main.getInstance().sc;
			String in = sc.next();
			int input;
			if(Tools.isNumeric(in)) {
				input=Integer.parseInt(in);
			} else {
				Input.wrongInput();
				continue;
			}
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
				showMenu();
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
	
	
	/*调试用*/
	public void test() {
//		Tools.horizontalLine();
//		System.out.println("修改自己的信息 -----------------1");
//		System.out.println("查询自己的信息 -----------------2");
//		System.out.println("程序退出-----------------------1");
//		System.out.println(changeInfoSql("ddd","fdfa' where i=1 --sf@dsfadf.dfas","hehe"));
//System.out.println("USERS_ID_AUTOINCREASE.NEXTVAL".toLowerCase());
		System.out.println(getRegSql("fgsadfg", "dfasfd", "63546", 656));
		
		
	}
	private String getRegSql(String name,String mail,String pw,int rights) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into users (id,name,email,password,rights) values (users_id_autoincrease.nextval,'");
		sb.append(name);
		sb.append("','");
		sb.append(mail);
		sb.append("','");
		sb.append(pw);
		sb.append("',");
		sb.append(rights);
		sb.append(")");
		return sb.toString();
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
	
	
	/*调试用 end*/
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
