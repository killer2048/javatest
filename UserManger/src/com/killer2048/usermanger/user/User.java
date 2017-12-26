package com.killer2048.usermanger.user;

import java.sql.SQLException;
import com.killer2048.usermanger.Main;
import com.killer2048.usermanger.sql.WithPreparedStatement;
import com.killer2048.usermanger.util.Input;
import com.killer2048.usermanger.util.Tools;

public class User implements UserI {
	// ��ͨ�û���Ϣ��
	protected int id;
	protected String name;
	protected String email;
	protected String pw;
	protected int rights;


	public User(int id, String name, String email, String pw, int rights) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.rights = rights;
	}

	public int getRights() {
		return rights;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
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
		System.out.println(id + "    " + name + "    " + email + "    "
				+ Main.getInstance().getRightList().get(Integer.valueOf(rights)));

	}

	@Override
	public void changeInfo(String name, String mail, String pw, int rights, UserI user) {
		// �޸�Ȩ�޼��
		if (user != this) {
			// ���Ǳ��˵��޸�
			if (!(user instanceof User) || user == null) {
				notAllow();
				return;
			}
			user = (User) user;
			if (user.getRights() <= Main.USERLEVEL || user.getRights() < this.rights) {
				notAllow();
				return;
			}
		}
		this.name = name;
		this.email = mail;
		this.pw = pw;
		this.rights = rights;
		int ret = changeInfoSql(name, mail, pw, rights);
		if (ret > 0) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}

	}

	@Override
	public void changeInfo() {
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
		changeInfo(name, mail, pw, this.rights, this);

	}

	protected void notAllow() {
		System.out.println("����Ȩ�޲���");
	}

	// protected String changeInfoSql(String name,String email,String pw) {
	// StringBuilder sb = new StringBuilder();
	// sb.append("update users set name='");
	// sb.append(name);
	// sb.append("',email='");
	// sb.append(email);
	// sb.append("',password='");
	// sb.append(pw);
	// sb.append("' where id=");
	// sb.append(id);
	// return sb.toString();
	// }
	protected int changeInfoSql(String name, String email, String pw, int rights) {
		int ret = 0;
		WithPreparedStatement sql = null;
		try {
			sql = new WithPreparedStatement(Main.getInstance().getConn().prepareStatement("update users set name= ? ,email= ? ,password= ? ,rights= ? where id= ?"));
			sql.set(1, name);
			sql.set(2, email);
			sql.set(3, pw);
			sql.set(4, rights);
			sql.set(5, this.id);
			ret = sql.update();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sql!=null) {
				try {
					sql.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	@Override
	public void getOperation() {
		while (true) {
			// ����ѭ������½�ɹ�
			showMenu();
			int input = Input.getInt();
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
				// TODO:�˳���ע����
				// ע��
				return;
			default:
				Input.wrongInput();
			}
		}
	}

	@Override
	public void sayHello() {
		System.out.println("��ӭ��¼������");
		System.out.println(name + "��ã�                      ���Ȩ���ǣ�    "
				+ Main.getInstance().getRightList().get(Integer.valueOf(rights)));

	}

	

}
