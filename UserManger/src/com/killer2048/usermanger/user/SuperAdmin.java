package com.killer2048.usermanger.user;

public class SuperAdmin extends Admin implements UserI,AdminI{

	public SuperAdmin(int id, String name, String email, String pw, int rights) {
		super(id, name, email, pw, rights);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("我是超级管理员~~呵呵呵");
		super.sayHello();
	}
	
	

}
