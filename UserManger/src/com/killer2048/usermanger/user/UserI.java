package com.killer2048.usermanger.user;
public interface UserI {

	void showMenu();//��ʾ�Լ��Ĳ˵�
	void showInfo();//��ѯ�Լ�����Ϣ
	void changeInfo(String name,String mail,String pw,int rights,UserI user);//�޸���Ϣ�������޸ķ����˵�user
	void changeInfo();//�޸���Ϣ�����벿��
	void getOperation();//����������ѡ�����
	void sayHello();//��ӡ�ʺ�
	int getRights();
	String getName();
	String getEmail();
	String getPw();
	int getId();
}
