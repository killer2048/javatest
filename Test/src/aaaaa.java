
public class aaaaa {
	public static void main(String[] args) {
		String s11 = "aa"+new String("bb");
		System.out.println(plus(100));
		int i=1;
		int s = 0;
		do{
			s+=i++;
		}
		while(i<=10);
		System.out.println(s);
		
		
		int[][] arr = new int[9][9];
		for(int m=0;m<9;m++) {
			for(int n=0;n<9;n++) {
				arr[m][n]=(m+1)*(n+1);
			}
		}
		for(int m=0;m<9;m++) {
			for(int n=0;n<9;n++) {
				System.out.print("\t"+(m+1)+"*"+(n+1)+"="+arr[m][n]+",");
			}
			System.out.println();
		}
	}
	
	public static int plus(int a) {
		if(a>1) {
			return a+plus(--a);
		} else {
			return 1;
		}
	}
	
}
