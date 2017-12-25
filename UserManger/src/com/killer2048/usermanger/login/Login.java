package com.killer2048.usermanger.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.user.*;
import com.killer2048.usermanger.util.*;

public class Login {
	User user;

	public User login() throws SQLException {
		// 获取相同的用户名的记录，之后比对密码
		System.out.println("用户登录主界面");
		Tools.horizontalLine();
		Scanner sc = Main.getInstance().sc;
		String name;
		String pw;
		user = null;// 每次登录时重置user
		while (true) {
			name = Input.getName(sc);
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			pw = Input.getPw(sc);
			if (pw != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		ResultSet rs = null;
		rs = Main.getInstance().query(createLoginSql(name));
		if (rs.next()) {
			// 检查密码
			String password = rs.getString("password");
			if (password != null && password.equals(pw)) {
				// 密码正确
				int id = Integer.parseInt(rs.getString("id"));
				String mail = rs.getString("email");
				int rights = Integer.parseInt(rs.getString("rights"));
				user = getRights(id, name, mail, password, rights);
			}
		}
		if (rs != null) {
			rs.close();
		}
		return user;

	}

	private User getRights(int id, String name, String mail, String pw, int rights) {
		// 根据权限返回对应的实例
		switch (rights) {
		case 1:
			return new User(id, name, mail, pw, rights);
		case 2:
			return new Admin(id, name, mail, pw, rights);
		case 3:
			return new SuperAdmin(id, name, mail, pw, rights);
		default:
			//todo:rights不在列表里
			return null;
		}

	}

	private String createLoginSql(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name,email,password,rights from users where name='");
		sb.append(name);
		sb.append("'");
		return sb.toString();
	}

	public boolean regist() throws SQLException {
		Scanner sc = Main.getInstance().sc;
		String name;
		String pw;
		String mail;
		while (true) {
			name = Input.getName(sc);
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			pw = Input.getPw(sc);
			if (pw != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			mail = Input.getMail(sc);
			if (mail != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		if (checkNameUsed(name)) {
			System.out.println("用户名已被使用");
			return false;
		}

		String sql = getRegSql(name, mail, pw);
		int ret = Main.getInstance().update(sql);
		if (ret > 0) {
			return true;
		}
		return false;
	}

	private String getRegSql(String name, String mail, String pw) {
		return getRegSql(name, mail, pw, 1);// 默认权限为1
	}

	private String getRegSql(String name, String mail, String pw, int rights) {
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

	// 检查用户名是否被使用
	private boolean checkNameUsed(String name) throws SQLException {
		int count = 1;
		ResultSet rs = null;
		rs = Main.getInstance().query("select count(id) as count from users where name='" + name + "'");
		if (rs.next()) {
			count = rs.getInt("count");
		}
		rs.close();

		if (count == 0) {
			return false;
		}
		return true;
	}

	public void loginSuccess(User user) {
		// 登录成功
		user.sayHello();
		user.getOperation();
	}

}
