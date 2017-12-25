package com.killer2048.usermanger.user;

public class Admin extends User implements UserI{

	public Admin(int id, String name, String email, String pw, int rights) {
		super(id, name, email, pw, rights);
	}

}
