package com.killer2048.usermanger.login;

import java.sql.ResultSet;
import java.util.Scanner;

import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.Tools;
import com.killer2048.usermanger.user.User;

public class Login {
	public  User login() {
		Scanner sc = Main.getInstance().sc;
		String name;
		String pw;
		while(true) {
			System.out.println("请输入用户名");
			name = sc.next();
			if(Tools.checkName(name)) {
				break;
			}
			Tools.inputCheckFalse();
		}
		while(true) {
			System.out.println("请输入密码");
			pw = sc.next();
			if(Tools.checkPW(pw)) {
				break;
			}
			Tools.inputCheckFalse();
		}
		ResultSet rs = Main.getInstance().query(createLoginSql(name));
	}
	private String createLoginSql(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name,email,password,rights from users where name='");
		sb.append(name);
		sb.append("'");
		return sb.toString();
	}
	
	
}
