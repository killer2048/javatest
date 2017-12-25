package hehehe;

import java.util.*;

public class t1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int temp;
		HashSet<Integer> res = new HashSet<>(); 
	    // ‰»Î
		for(int i=0;i<k;i++) {
			res.add(Math.abs(sc.nextInt()));
	    }
		System.out.println(k-res.size());
	}
}
