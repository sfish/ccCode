package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: Shunzi.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-17 上午11:02:18
 * @version V1.0
 */
public class Shunzi {

	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while (n != 0) {
			int[] val = new int[n];
			for (int i = 0; i < n; i++)
				val[i] = sc.nextInt();
			boolean b = check(val);
			if (b)
				System.out.println("So Lucky!");
			else
				System.out.println("Oh My God!");
			n = sc.nextInt();

		}
	}

	public static boolean check(int[] val) {
		if (val == null)
			return false;

		sort(val);
		System.out.println(Arrays.toString(val));
		int count = 0, pre = -1;
		for (int i = 0; i < val.length; i++) {
			if (val[i] == 0)
				count++;
			else {
				if (pre != -1) {
					int dis = val[i] - pre;
					if (dis == 0) // 这句话很重要啊！！！！
						return false;
					if (dis > 1) {
						count -= dis - 1;
						if (count < 0)
							return false;
					}
				}
				pre = val[i];

			}
		}
		return true;
	}

	public static void sort(int[] a) {
		int[] sum = new int[15];
		Arrays.fill(sum, 0);
		for (int i = 0; i < a.length; i++)
			sum[a[i]]++;

		int index = 0;
		for (int i = 0; i < sum.length; i++) {
			for (int j = sum[i]; j > 0; j--) {
				a[index] = i;
				index++;
			}
		}
	}
}
