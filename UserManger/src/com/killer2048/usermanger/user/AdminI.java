package com.killer2048.usermanger.user;

interface AdminI {
//����Ա�ӿ�
	void addUser();
	void delUser();
	void changeUser();
	void findUser();
	UserI getUserFromId(int id);//��id��ȡ�û�
}
