package com.killer2048.objpro.tt;

public class Example{
private int i = giveMeJ();
private int j = 10; //对象创建时先声明变量，并付默认值，创建完成后再赋值
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
//成员的赋值先后顺序：初始值- >声明时默认值->构造函数赋值
 }
