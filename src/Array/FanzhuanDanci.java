package Array;

import java.util.Scanner;

/**
 * @Title: FanzhuanDanci.java
 * @Package Array
 * @Description: TODO
 * @author nutc
 * @date 2013-8-17 下午2:56:19
 * @version V1.0
 */
public class FanzhuanDanci {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String s = sc.nextLine();
			String[] re = s.split(" ");
//			if (re.length == 2) {
				char[] c = re[0].toCharArray();
				int k = Integer.parseInt(re[1]);
				LeftRotate(c, k);
//			}else{
//				System.out.print(b)
//			}
			// reverseSentence(c);
			
		}
	}

	public static void reverseSentence(char[] s) {
		if (s == null || s.length == 0)
			return;
		int i = 0, j = 0;
		while (i < s.length) {
			while (i < s.length && s[i] == ' ')
				i++; // 数组边界的判断啊 啊！
			j = i + 1;
			while (j < s.length && s[j] != ' ')
				j++; // 数组边界的判断啊 啊！
			reverse(s, i, j - 1);
			i = j;
		}
		reverse(s, 0, s.length - 1);
		// char[] re = new char[s.length];
		// int index = 0;
		// for (int k = 0; k < s.length; k++) {
		// if (s[k] == ' ' && k - 1 > 0 && s[k - 1] == ' ') {
		// k++;
		// } else {
		// re[index++] = s[k];
		// }
		// }
		System.out.println(String.valueOf(s)); // char[] to String !!

	}

	public static void LeftRotate(char[] s, int k) {
		if (s == null || s.length < 1 || k < 0)
			return;

		k = k % s.length;
		reverse(s, 0, k - 1);
		reverse(s, k, s.length - 1);
		reverse(s, 0, s.length - 1);
		System.out.println(String.valueOf(s));
	}

	public static void reverse(char[] s, int start, int end) {
		// System.out.println(Arrays.toString(s)+" "+start+" "+end);
		if (s == null || s.length == 0 || end >= s.length || start < 0)
			return; // 数组边界的判断啊 啊！

		int i = start, j = end;
		while (i < j) { // 之前写 i!=j 非常挫！！！ 有可能不存在相等的情况啊！！！
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--; // 写成++l .....
		}
	}
}
