package com.killer2048.usermanger.user;

public class Admin extends User implements UserI,AdminI{

	public Admin(int id, String name, String email, String pw, int rights) {
		super(id, name, email, pw, rights);
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("���ǹ���Ա");
		super.sayHello();
	}
	
	

}
