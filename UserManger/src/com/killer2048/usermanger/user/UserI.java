package com.killer2048.usermanger.user;
public interface UserI {

	void showMenu();//显示自己的菜单
	void showInfo();//查询自己的信息
	void changeInfo(String name,String mail,String pw,int rights,UserI user);//修改信息，传入修改发起人的user
	void changeInfo();//修改信息的输入部分
	void getOperation();//由输入的序号选择操作
	void sayHello();//打印问候
	int getRights();
	String getName();
	String getEmail();
	String getPw();
	int getId();
}
