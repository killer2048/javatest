package com.killer2048.objpro.tt;

public class Example{
private int i = giveMeJ();
private int j = 10; //���󴴽�ʱ����������������Ĭ��ֵ��������ɺ��ٸ�ֵ
private int giveMeJ(){
 return j;
 } 

public Example () {
	j=100;
}
public static void main(String args[]){
 System.out.println((new Example()).i);//0
 System.out.println((new Example()).j);//100
 //
 }
//��Ա�ĸ�ֵ�Ⱥ�˳�򣺳�ʼֵ- >����ʱĬ��ֵ->���캯����ֵ
 }
