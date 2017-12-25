package t201703;
import java.util.Scanner;

public class t2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p;
		int q;
		//生成初始队列
		int[] line = new int[n];
		int[] pos = new int[n];//学号=>line的Index
		for(int i=0;i<n;i++) {
			line[i]=i;
			pos[i]=i;
		}
		for(int i=0;i<m;i++) {
			p = sc.nextInt();
			q = sc.nextInt();
			move(line,pos,p-1,q);
		}
	
		for(int i=0;i<n;i++) {
			System.out.print(line[i]+1);
			if(i<n-1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}
	
	public static void move(int[] line,int[] pos,int num,int step) {
		boolean next=true;
		if(step<0){
			step=-step;
			next = false;
		}
		for(int i=0;i<step;i++) {
			moveOne(line,pos,num,next);
		}
	}
	
	public static void moveOne(int[] line,int[] pos,int num,boolean next) {
		int step = next?1:-1;//前后移动
		line[pos[num]]=line[pos[num]]^line[pos[num]+step];
		line[pos[num]+step]=line[pos[num]]^line[pos[num]+step];
		line[pos[num]]=line[pos[num]]^line[pos[num]+step];
		int a = line[pos[num]];//另一个人的学号
		pos[num]=pos[num]+step;
		pos[a] = pos[num]-step;
	}
	
}
