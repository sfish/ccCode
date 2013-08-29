package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: findFirstNot.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-18 обнГ8:51:02
 * @version V1.0
 */
public class findFirstNot {

	public static void main(String args[]) {
		int n;
		Scanner s = new Scanner(System.in);

		while (s.hasNext()) {
			n = s.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			// subsum(a);
			System.out.println(find(a));
		}
	}

	public static int find(int[] a) {
		int[] count = new int[5051];
		Arrays.fill(count, 0);
		for (int i = 0; i < a.length; i++) {
			count[a[i]] = 1;
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < count.length; j++) {
				if(count[j]!=0 && a[i]+j<count.length){
					System.out.println(a[i]+" "+j);
					count[a[i] + j] = 1;
				}
			}
			System.out.println(Arrays.toString(count));
		}
		
		for (int i = 1; i < count.length; i++) {
			if (count[i] == 0)
				return i;
		}
		return 0;
	}
}
