package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: Over_Half.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-20 下午1:26:34
 * @version V1.0
 */
public class Over_Half {

	public static void main(String args[]) {
		int n;
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			n = s.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			System.out.println(find2(a));
		}
	}

	public static int find2(int[] a) {
		if (a == null)
			return -1;
		Arrays.sort(a);

		int mid = a[a.length >> 1];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (mid == a[i])
				count++;
		}
		if (count * 2 >= a.length)
			return mid;
		else
			return -1;
	}

	// 该方法必须是已知有超过一半的！！！！
	public static int find(int[] a) {
		if (a == null)
			return -1;
		int count = 1, value = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] != value) {
				count--;
				if (count == 0) {
					value = a[i];
				}
			} else {
				count++;
			}
		}
		if (count >= (a.length >> 1)) {
			return value;
		} else
			return -1;
	}
}
