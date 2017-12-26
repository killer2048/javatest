package com.killer2048.usermanger.user;

import java.sql.SQLException;

import com.killer2048.usermanger.util.Input;

public class SuperAdmin extends Admin implements UserI,AdminI{

	public SuperAdmin(int id, String name, String email, String pw, int rights) {
		super(id, name, email, pw, rights);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void addUser() {
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
		boolean success = false;
		try {
			success = createUser(name,mail,pw,2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		if(success) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		
	}
	

}
