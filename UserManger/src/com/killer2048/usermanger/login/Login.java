package com.killer2048.usermanger.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.sql.WithPreparedStatement;
import com.killer2048.usermanger.user.*;
import com.killer2048.usermanger.util.*;

public class Login {
	UserI user;
	public UserI login() throws SQLException {
		// ��ȡ��ͬ���û����ļ�¼��֮��ȶ�����
		System.out.println("�û���¼������");
		Tools.horizontalLine();
		String name=null;
		String pw=null;
		user = null;// ÿ�ε�¼ʱ����user
		while (true) {
			name = Input.getName();
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			pw = Input.getPw();
			if (pw != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		ResultSet rs = null;
		WithPreparedStatement sql = createLoginSql(name);
		rs = sql.query();
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
		sql.close();
		if (rs != null) {
			rs.close();
		}
		return user;

	}

	private UserI getRights(int id, String name, String mail, String pw, int rights) {
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

//	private String createLoginSql(String name) {
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("select id,name,email,password,rights from users where name='");
//		sb.append(name);
//		sb.append("'");
//		return sb.toString();
//	}
	private WithPreparedStatement createLoginSql(String name) throws SQLException {
		WithPreparedStatement loginPs = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("select id,name,email,password,rights from users where name= ?"));
		loginPs.set(1, name);
		return loginPs;
	}

	public boolean regist() throws SQLException {
		String name=null;
		String pw=null;
		String mail=null;
		while (true) {
			name = Input.getName();
			if (name != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			pw = Input.getPw();
			if (pw != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while (true) {
			mail = Input.getMail();
			if (mail != null) {
				break;
			}
			Input.inputCheckFalse();
		}
		if (Tools.checkNameUsed(name)) {
			System.out.println("�û����ѱ�ʹ��");
			return false;
		}

		WithPreparedStatement sql = getRegSql(name, mail, pw);
		int ret = sql.update();
		sql.close();
		if (ret > 0) {
			return true;
		}
		return false;
	}


	
	private WithPreparedStatement getRegSql(String name, String mail, String pw) throws SQLException {
		return getRegSql(name, mail, pw, Main.USERLEVEL);
	}
	
	private WithPreparedStatement getRegSql(String name, String mail, String pw, int rights) throws SQLException {
		WithPreparedStatement regPs = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("insert into users (id,name,email,password,rights) values (users_id_autoincrease.nextval,?,?,?,?)"));
		regPs.set(1, name);
		regPs.set(2, mail);
		regPs.set(3, pw);
		regPs.set(4, rights);
		return regPs;
	}

	

	public void loginSuccess(UserI user) {
		// ��¼�ɹ�
		user.sayHello();
		user.getOperation();
	}

}
