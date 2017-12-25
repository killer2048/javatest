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
		// ��ȡ��ͬ���û����ļ�¼��֮��ȶ�����
		System.out.println("�û���¼������");
		Tools.horizontalLine();
		Scanner sc = Main.getInstance().sc;
		String name;
		String pw;
		user = null;// ÿ�ε�¼ʱ����user
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
			// �������
			String password = rs.getString("password");
			if (password != null && password.equals(pw)) {
				// ������ȷ
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
		// ����Ȩ�޷��ض�Ӧ��ʵ��
		switch (rights) {
		case 1:
			return new User(id, name, mail, pw, rights);
		case 2:
			return new Admin(id, name, mail, pw, rights);
		case 3:
			return new SuperAdmin(id, name, mail, pw, rights);
		default:
			//todo:rights�����б���
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
			System.out.println("�û����ѱ�ʹ��");
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
		return getRegSql(name, mail, pw, 1);// Ĭ��Ȩ��Ϊ1
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

	// ����û����Ƿ�ʹ��
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
		// ��¼�ɹ�
		user.sayHello();
		user.getOperation();
	}

}
