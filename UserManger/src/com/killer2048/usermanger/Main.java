package com.killer2048.usermanger;

import java.sql.*;
import java.util.*;

import com.killer2048.usermanger.login.Login;
import com.killer2048.usermanger.user.*;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class Main {
//��������
	//jdbc����
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
			System.out.println("�����ļ�ȱʧ");
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ʼ��ʧ�ܣ��˳�");
			System.exit(1);
		}
		Main.getInstance().run();
		
//		Main.getInstance().test();
	}
	
	public void run() {
		//���г���
		getOperation();
	}
	
	
	private void showMenu() {
		//��ʾ���˵�
		System.out.println("��ӭʹ���û�����ϵͳ");
		Tools.horizontalLine();
		System.out.println("�û���¼-----------------------1");
		System.out.println("�û�ע��-----------------------2");
		System.out.println("�����˳�-----------------------3");
	}
	private void getOperation() {
		Login lg = new Login();
		while(true) {
			//ѭ�������˵�ѡ��
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
					System.out.println("�������");
					curruser=null;
				}
				if(curruser!=null) {
					//��¼�ɹ�
					System.out.println("��¼�ɹ�");
					lg.loginSuccess(curruser);
				} else {
					System.out.println("�û������������");
				}
				break;
			case 2:
				boolean success=false;
				try {
					success = lg.regist();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("�������");
				}
				if(success) {
					System.out.println("ע��ɹ�");
				} else {
					System.out.println("ע��ʧ��");
				}
				break;
			case 3:
				//TODO:�˳���ע����
				//ע��
				exit();
			default:
				Input.wrongInput();
				showMenu();
			}
			//��ѭ��һȦ����ע���û������û������в�����ɣ��ص���¼��
			Main.getInstance().logout();
		}
	}
	
	public void init() throws ClassNotFoundException, SQLException {
		//������ʼ��
		//���ݿ����
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		sc = new Scanner(System.in);
		st = conn.createStatement();
		//��ȡȨ���б�
		ResultSet rt = query("select id,text from rights");
		Map<Integer,String> rlist = new HashMap<>();
		while(rt.next()) {
			rlist.put(Integer.valueOf(rt.getString("id")),rt.getString("text"));
		}
		rightList=rlist;
		
		
	}
	public void logout() {
//		��ǰ�û�ע��
		curruser=null;
	}
	
	
	/*������*/
	public void test() {
//		Tools.horizontalLine();
//		System.out.println("�޸��Լ�����Ϣ -----------------1");
//		System.out.println("��ѯ�Լ�����Ϣ -----------------2");
//		System.out.println("�����˳�-----------------------1");
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
	
	
	/*������ end*/
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
		System.out.println("�������˳�");
		System.exit(0);
	}
	
	public ResultSet query(String sql) throws SQLException {
		return st.executeQuery(sql);
		 
	}
	
	public int update(String sql) throws SQLException {
		return st.executeUpdate(sql);
	}
	
	
}
