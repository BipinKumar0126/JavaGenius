package problemSolving;

import java.util.Scanner;

public class BigSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		long sum = 0;

		for(int i=0 ; i < n;  i++){
			arr[i] = sc.nextInt();
			sum = sum + arr[i];
		}
		System.out.println(sum);
		sc.close();

	}

}