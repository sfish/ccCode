package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title: Longest_No_repeat.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-18 下午7:07:17
 * @version V1.0
 */
public class Longest_No_repeat {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			char[] c = s.toCharArray();
			System.out.println(find(c));
		}
	}

	public static int find(char[] str) {
		if (str == null)
			return 0;
		int[] count = new int[26];
		Arrays.fill(count, -1);

		int max = 0, nowmax = 0, nowstart = 0;

		for (int i = 0; i < str.length; i++) {
			int index = str[i] - 'a';
			if (count[index] != -1 && count[index] >= nowstart) { // 第二个判断条件非常的重要！非常！！
				nowmax -= (count[index] - nowstart + 1);
				nowstart = count[index] + 1;
			}
			nowmax++;
			count[index] = i;
			if (nowmax > max)
				max = nowmax;
		}
		return max;
	}
}
