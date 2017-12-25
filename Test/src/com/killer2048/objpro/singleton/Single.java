package com.killer2048.objpro.singleton;

//单例模式
public class Single {
	private static Single single = new Single();//创建静态变量保存唯一的对象
	private Single(){
		//私有构造器,阻止外部生成对象
	}
	
	public static Single getInstance() {
		//提供一个返回对象的静态方法
		return single;
	}
	
	public static void main(String[] args) {
		//呵呵
		System.out.println(Single.single);
		System.out.println(Single.single.single);
		System.out.println(Single.single.single.single);
		System.out.println(Single.single.single.single.single.single);
	}
}
