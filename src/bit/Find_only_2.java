package bit;

import java.util.Arrays;

/**
 * @Title: Find_only_2.java
 * @Package bit
 * @Description: TODO
 * @author nutc
 * @date 2013-8-14 上午10:50:16
 * @version V1.0
 */
public class Find_only_2 {

	public static void main(String args[]) {
		int[] a = { 3333,559686,11,22,11,22,4,4 };
		int[] r = find(a);
		System.out.println((3^5) +" ");
		System.out.println(Arrays.toString(r));
	}

	public static int[] find(int a[]) {
		if (a == null || a.length < 2)
			return null;
		int value = 0; // 这里是可以直接0的！！
		for (int i = 0; i < a.length; i++) {
			value ^= a[i];
		}
		System.out.println("value" + value);
		int index = findIndex(value);
		System.out.println("index" + index);
		int judge = 1 << index;
		System.out.println("judge" + judge);
		int value1 = 0, value2 = 0;
		for (int i = 0; i < a.length; i++) {
			if ((a[i] & judge) == judge) {   //致命的错误！！致命！！！
				value1 ^= a[i];
			} else {
				value2 ^= a[i];
			}
		}

		int[] result = { value1, value2 };
		return result;

	}

	public static int findIndex(int value) {
		int index = 0;
		while ((value & 1 << index) == 0) {
			index++;
		}
		return index;
	}
}
