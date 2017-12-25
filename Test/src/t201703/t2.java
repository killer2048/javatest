package t201703;
import java.util.Scanner;

public class t2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p;
		int q;
		//���ɳ�ʼ����
		int[] line = new int[n];
		int[] pos = new int[n];//ѧ��=>line��Index
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
		int step = next?1:-1;//ǰ���ƶ�
		line[pos[num]]=line[pos[num]]^line[pos[num]+step];
		line[pos[num]+step]=line[pos[num]]^line[pos[num]+step];
		line[pos[num]]=line[pos[num]]^line[pos[num]+step];
		int a = line[pos[num]];//��һ���˵�ѧ��
		pos[num]=pos[num]+step;
		pos[a] = pos[num]-step;
	}
	
}
