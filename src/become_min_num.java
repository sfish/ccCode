import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Title: become_min_num.java
 * @Package
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author nutc
 * @date 2013-8-13 下午8:57:48
 * @version V1.0
 */
public class become_min_num {

	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0;i<n;i++)
				a[i] = sc.nextInt();
			System.out.println(min(a));
		}
	}

	public static String min(int a[]) {
		if (a == null)
			return null;
		String[] value = new String[a.length];
		for (int i = 0; i < value.length; i++) {
			value[i] = intToString(a[i]);
		}
		Mycomparator my  = new Mycomparator();
		Arrays.sort(value,my);

//		 Arrays.toString(value);
		StringBuilder min = new StringBuilder("");
		for (int i = 0; i < value.length; i++) {
			min.append(value[i]);
		}
		String m = min.toString();
		return m;
	}

	public static String intToString(int v) {
		return String.valueOf(v);// TODO
	}

	public static class Mycomparator implements Comparator<String> {  //static !!!!

		public int compare(String t1, String t2) {
			String new1 = t1 + t2;  //TODO
			String new2 = t2 + t1;
			int result = new1.compareTo(new2);
			if (result > 0) {
				return 1;
			} else if (result < 0)
				return -1;
			else
				return 0;
		}
	}
}
