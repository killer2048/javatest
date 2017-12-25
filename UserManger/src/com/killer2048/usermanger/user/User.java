package com.killer2048.usermanger.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class User implements UserI {
	// ��ͨ�û���Ϣ��
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
		System.out.println("�޸��Լ�����Ϣ -----------------1");
		System.out.println("��ѯ�Լ�����Ϣ -----------------2");
		System.out.println("�����˳�-----------------------3");

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
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
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
			//����ѭ������½�ɹ�
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
				System.out.println("�����ڵ���Ϣ�ǣ�");
				showInfo();
				changeInfo();
				break;
			case 2:
				showInfo();
				break;
			case 3:
				//TODO:�˳���ע����
				//ע��
				return;
			default:
				Input.wrongInput();
				showMenu();
			}
		}
	}

	@Override
	public void sayHello() {
		System.out.println("��ӭ��¼������");
		System.out.println(name+"��ã�                      ���Ȩ���ǣ�    "+Main.getInstance().getRightList().get(Integer.valueOf(rights)));
		
	}
	
	
	
}
