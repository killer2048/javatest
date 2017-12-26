package com.killer2048.usermanger.user;

interface AdminI {
//管理员接口
	void addUser();
	void delUser();
	void changeUser();
	void findUser();
	UserI getUserFromId(int id);//由id获取用户
}
