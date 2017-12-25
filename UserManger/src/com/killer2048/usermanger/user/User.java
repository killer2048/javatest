package com.killer2048.usermanger.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class User implements UserI {
	// 普通用户信息类
	private int id;
	private String name;
	private String email;
	private String pw;
	private int rights;

	public User(int id, String name, String email, String pw, int rights) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.rights = rights;
	}

	@Override
	public void showMenu() {
		Tools.horizontalLine();
		System.out.println("修改自己的信息 -----------------1");
		System.out.println("查询自己的信息 -----------------2");
		System.out.println("程序退出-----------------------3");

	}

	@Override
	public void showInfo() {
		System.out.println(id+"    "+name+"    "+email+"    "+Main.getInstance().getRightList().get(Integer.valueOf(rights)));

	}

	@Override
	public void changeInfo() {
		Scanner sc = Main.getInstance().sc;
		String name;
		String pw;
		String mail;
		while(true) {
			name = Input.getName(sc);
			if(name!=null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while(true) {
			pw = Input.getPw(sc);
			if(pw!=null) {
				break;
			}
			Input.inputCheckFalse();
		}
		while(true) {
			mail = Input.getMail(sc);
			if(mail!=null) {
				break;
			}
			Input.inputCheckFalse();
		}
		this.name=name;
		this.email=mail;
		this.pw=pw;
		try {
			if(Main.getInstance().update(changeInfoSql(name, mail, pw)) >0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected String changeInfoSql(String name,String email,String pw) {
		StringBuilder sb = new StringBuilder();
		sb.append("update users set name='");
		sb.append(name);
		sb.append("',email='");
		sb.append(email);
		sb.append("',password='");
		sb.append(pw);
		sb.append("' where id=");
		sb.append(id);
		return sb.toString();
	}
	
	

	@Override
	public void getOperation() {
		while(true) {
			//二级循环，登陆成功
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
				Tools.horizontalLine();
				System.out.println("你现在的信息是：");
				showInfo();
				changeInfo();
				break;
			case 2:
				showInfo();
				break;
			case 3:
				//TODO:退出？注销？
				//注销
				return;
			default:
				Input.wrongInput();
				showMenu();
			}
		}
	}

	@Override
	public void sayHello() {
		System.out.println("欢迎登录主窗体");
		System.out.println(name+"你好：                      你的权限是：    "+Main.getInstance().getRightList().get(Integer.valueOf(rights)));
		
	}
	
	
	
}
