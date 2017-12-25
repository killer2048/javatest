
public class Reb {
	public static void main(String[] args) {
//		System.out.println(getReb(47));
		
		Object a = null;
		((aa)a).aaa();
		aa aaa = null;
		System.out.println(aaa instanceof aa);
	
	}
	
	public static long getReb(int mon) {
		if(mon-2>0) {
			return getReb(mon-1)+getReb(mon-2);
		} else {
			return 1l;
		}
		
		
		
	}
}

class aa{
	static void aaa() {
		System.out.println("aaa");
	}
}
