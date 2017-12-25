package com.killer2048.objpro.chouxiang;

public interface Jiekou {
	//只能被赋值一次，没有初始值
	/*public final static*/ int a = 1;//接口中所有变量为常量，默认加public final static,需要在声明时赋值
	/*public abstract*/ void fly();//接口中所有的方法默认为抽象方法，默认加public abstract
	
	void fly2();
}
