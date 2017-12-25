package t201703;

import java.util.Scanner;

public class t1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int k;
		int count = 0;
		int weight = 0;

		n = sc.nextInt();
		k = sc.nextInt();

		for (int i = 0; i < n; i++) {
			weight += sc.nextInt();
			if (weight >= k) {
				weight = 0;
				count++;
			}
		}
		if (weight >= 0) {
			count++;
		}
		System.out.println(count);
		sc.close();
	}
}
