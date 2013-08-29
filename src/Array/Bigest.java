package Array;

import java.util.Scanner;

/**
 * @Title: Bigest.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-18 下午7:30:45
 * @version V1.0
 */
public class Bigest {

	public static void main(String args[]) {
		int L = 8;
		int[][] array = new int[L][L]; 
		int limit;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			limit = sc.nextInt();
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < L; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			// System.out.println(find(array));
			int result = findlimit(array, L - 1, L - 1, limit, limit);
			if (result == Integer.MIN_VALUE)
				System.out.println("-1");
			else
				System.out.println(result);

		}
	}

	public static int findlimit(int[][] a, int i, int j, int limit, int sum) {
		// 先把递归公式先写出来.....比神马都重要！！！！！！
		// System.out.println(i+" "+j+" "+sum);
		if (sum < 0 || i < 0 || j < 0)
			return Integer.MIN_VALUE;

		if (i == 0 && j == 0) {
			if (sum >= a[i][j])
				return a[i][j];
			else
				return Integer.MIN_VALUE;
		}

		int sum1 = Integer.MIN_VALUE, sum2 = sum1;
		sum1 = findlimit(a, i - 1, j, limit, sum - a[i][j]);
		sum2 = findlimit(a, i, j - 1, limit, sum - a[i][j]);
		int now = sum1 > sum2 ? sum1 : sum2;
		if (now != Integer.MIN_VALUE)
			now += a[i][j];
		return now;
	}

	// public static int find(int[][] a) {
	// if (a == null)
	// return 0;
	//
	// int[][] sum = a;
	//
	// for (int i = 0; i < a.length; i++) {
	// for (int j = 0; j < a[0].length; j++) {
	// if (i == 0 && j == 0)
	// continue;
	// int val1 = -1, val2 = -1;
	// if (i - 1 >= 0)
	// val1 = sum[i - 1][j];
	// if (j - 1 >= 0)
	// val2 = sum[i][j - 1];
	// sum[i][j] += val1 > val2 ? val1 : val2;
	// }
	// }
	// return sum[sum.length - 1][sum.length - 1];
	// }
}
