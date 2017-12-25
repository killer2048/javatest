package com.killer2048.usermanger.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.user.User;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class Login {
	User user;

	public User login() {
		// 获取相同的用户名的记录，之后比对密码
		Scanner sc = Main.getInstance().sc;
		String name;
		String pw;
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
		try {
			rs = Main.getInstance().query(createLoginSql(name));
			if (rs.next()) {
				// 检查密码
				String password = rs.getString("password");
				if (password != null && password.equals(pw)) {
					user = new User(Integer.parseInt(rs.getString("id")), rs.getString("name"), rs.getString("email"),
							rs.getString("password"), Integer.parseInt(rs.getString("rights")));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;

	}

	private String createLoginSql(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name,email,password,rights from users where name='");
		sb.append(name);
		sb.append("'");
		return sb.toString();
	}

	public boolean regist() {
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

}
